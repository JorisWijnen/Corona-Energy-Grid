package com.corona.backend.repositories;

import com.corona.backend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long id);
    User findUserByEmail(String email);

    Boolean checkIfEmailExists(String email);
    Boolean checkIfCustomerCodeIsCorrect(String customerCode);
}
