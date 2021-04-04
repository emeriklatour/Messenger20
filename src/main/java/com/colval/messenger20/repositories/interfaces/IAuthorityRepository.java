package com.colval.messenger20.repositories.interfaces;

import com.colval.messenger20.model.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorityRepository extends JpaRepository<Authorities, Long> {
}
