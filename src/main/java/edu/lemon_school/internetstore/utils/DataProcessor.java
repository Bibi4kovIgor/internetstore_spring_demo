package edu.lemon_school.internetstore.utils;

import edu.lemon_school.internetstore.annotation.DataField;
import edu.lemon_school.internetstore.annotation.DataObject;
import edu.lemon_school.internetstore.dto.Dto;
import edu.lemon_school.internetstore.entity.EntityModel;


import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.Objects;

public class DataProcessor {
    public static void entityToData (Dto dto, EntityModel entity) {
        if (!dto.getClass().isAnnotationPresent(DataObject.class)) {
            throw new RuntimeException("Dto class is wrong");
        }

        Field[] dtoFields = dto.getClass().getFields();
        Field[] entityFields = entity.getClass().getFields();
        for (Field field : dtoFields) {
            if(!field.isAnnotationPresent(DataField.class)) {
                throw new RuntimeException("Dto field is wrong");
            }

            dtoToEntityData(field, entityFields);

        }
    }

    private static void dtoToEntityData(Field dtoField, Field[] entityFields) {
        for (Field entityField : entityFields) {
            if (Objects.equals(
                    entityField.getDeclaredAnnotation(Column.class).name(),
                    dtoField.getDeclaredAnnotation(DataField.class).name())
                && Objects.equals(
                        dtoField.getDeclaredAnnotation(DataField.class).type(),
                        entityField.getType().getName())
            ) {

                dtoField.setAccessible(true);
                entityField.setAccessible(true);

                dtoField = entityField;
            }
        }
    }
}
