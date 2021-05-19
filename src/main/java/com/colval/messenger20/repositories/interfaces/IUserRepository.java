package com.colval.messenger20.repositories.interfaces;

import com.colval.messenger20.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users, Short> {
    Users findByUsername(String username);

}
