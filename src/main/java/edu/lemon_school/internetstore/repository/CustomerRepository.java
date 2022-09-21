package edu.lemon_school.internetstore.repository;


import edu.lemon_school.internetstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query(value = "select customer from Customer customer " +
            " where customer.firstName like %:name%")
    List<Customer> getCustomersByNane(@Param("name") String name);

}
