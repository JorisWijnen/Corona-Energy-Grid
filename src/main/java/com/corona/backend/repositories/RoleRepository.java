package com.corona.backend.repositories;

import com.corona.backend.models.CustomGrantedAuthority;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<CustomGrantedAuthority, Long > {
}

