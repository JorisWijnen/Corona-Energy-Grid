package com.corona.backend.repositories;

import com.corona.backend.models.Status;
import com.corona.backend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
    Status findStatusById(Long id);

}
