package com.colval.messenger20.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_conversation")
public class UserConversation {
    @Id
    @Column(name = "user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private long userId;

    @Id
    @Column(name = "conversation_id")
    private long conversationId;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }
}
