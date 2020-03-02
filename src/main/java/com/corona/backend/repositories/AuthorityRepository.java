package com.corona.backend.repositories;

import com.corona.backend.models.CustomGrantedAuthority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<CustomGrantedAuthority, Long > {
}

