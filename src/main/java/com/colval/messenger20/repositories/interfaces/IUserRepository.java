package com.colval.messenger20.repositories.interfaces;

import com.colval.messenger20.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
