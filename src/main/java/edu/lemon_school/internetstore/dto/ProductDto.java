package edu.lemon_school.internetstore.dto;

import edu.lemon_school.internetstore.entity.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class ProductDto {

    private String id;

    private String name;

    private double price;

    private String description;

    private Set<Customer> customers;

    public static ProductDtoBuilder builder(){
        return ProductDtoBuilder.builder();
    }


    public static final class ProductDtoBuilder {
        private final ProductDto productDto;

        private ProductDtoBuilder() {
            productDto = new ProductDto();
        }

        public static ProductDtoBuilder builder() {
            return new ProductDtoBuilder();
        }

        public ProductDtoBuilder id(String id) {
            productDto.setId(id);
            return this;
        }

        public ProductDtoBuilder name(String name) {
            productDto.setName(name);
            return this;
        }

        public ProductDtoBuilder price(double price) {
            productDto.setPrice(price);
            return this;
        }

        public ProductDtoBuilder description(String description) {
            productDto.setDescription(description);
            return this;
        }

        public ProductDtoBuilder customers(Set<Customer> customers) {
            productDto.setCustomers(customers);
            return this;
        }

        public ProductDto build() {
            return productDto;
        }
    }
}
