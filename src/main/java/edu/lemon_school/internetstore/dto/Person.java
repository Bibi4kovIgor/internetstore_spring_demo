package edu.lemon_school.internetstore.dto;

import edu.lemon_school.internetstore.annotation.DataField;
import edu.lemon_school.internetstore.annotation.DataObject;
import edu.lemon_school.internetstore.annotation.Validate;

@DataObject
public class Person implements Dto {
    @DataField(name = "id")
    private String id;

    @DataField(name = "name")
    private String name;

    @DataField(name = "email")
    private String email;

    @DataField(name = "phoneNumber")
    @Validate
    private String phoneNumber;

}
