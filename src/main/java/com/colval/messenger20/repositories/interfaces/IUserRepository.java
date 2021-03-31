package com.colval.messenger20.repositories.interfaces;

import com.colval.messenger20.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
}
