package com.colval.messenger20.services;

import com.colval.messenger20.model.entities.Conversations;

public interface IConversationService {
    Conversations readOne(int conversationId);
}
