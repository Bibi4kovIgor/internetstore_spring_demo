package edu.lemon_school.internetstore.repository;

import edu.lemon_school.internetstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select user from User user " +
            " where user.userName = :name")
    User findUserByName(@Param("name") String name);
}
