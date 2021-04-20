package com.colval.messenger20.repositories.interfaces;

import com.colval.messenger20.controllers.IndexController;
import com.colval.messenger20.model.entities.Conversations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IConversationRepository extends JpaRepository<Conversations, Long> {

}
