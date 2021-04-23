package com.colval.messenger20.repositories.interfaces;

import com.colval.messenger20.model.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepository extends JpaRepository<Messages, Long> {
}
