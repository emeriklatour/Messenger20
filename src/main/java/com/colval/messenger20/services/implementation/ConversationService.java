package com.colval.messenger20.services.implementation;

import com.colval.messenger20.model.entities.Conversations;
import com.colval.messenger20.repositories.interfaces.IConversationRepository;
import com.colval.messenger20.services.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService implements IConversationService {
    private final IConversationRepository conversationRepository;

    @Autowired
    public ConversationService(IConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public Conversations readOne(int conversationId) {
        return conversationRepository.findById(conversationId);
    }
}
