package com.colval.messenger20.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Column(name = "content")
    private String content;

    @Column(name = "sent_date")
    private Date sentDate;


    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private User user;

    @JoinColumn(name = "conversation_id", referencedColumnName = "conversation_id")
    @ManyToOne
    private Conversation conversation;

    public long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSentDate() {
        return this.sentDate;
    }

    public void setSentDate(java.sql.Timestamp sentDate) {
        this.sentDate = sentDate;
    }

    public User getUserId() {
        return this.user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public Conversation getConversationId() {
        return this.conversation;
    }

    public void setConversationId(Conversation conversation) {
        this.conversation = conversation;
    }
}
