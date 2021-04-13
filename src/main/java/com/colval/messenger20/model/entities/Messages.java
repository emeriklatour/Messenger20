package com.colval.messenger20.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Messages implements Serializable {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Column(name = "content")
    private String content;

    @Column(name = "chat_type")
    private String chatType;

    @Column(name = "sent_date")
    private Date sentDate;


    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Users users;

    @JoinColumn(name = "conversation_id", referencedColumnName = "conversation_id")
    @ManyToOne
    private Conversations conversations;

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

    public Users getUserId() {
        return this.users;
    }

    public void setUserId(Users users) {
        this.users = users;
    }

    public Conversations getConversationId() {
        return this.conversations;
    }

    public void setConversationId(Conversations conversations) {
        this.conversations = conversations;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }
}
