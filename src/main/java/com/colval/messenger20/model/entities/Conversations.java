package com.colval.messenger20.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversations")
@NamedQueries({
        @NamedQuery(name = "Conversations.findById", query = "SELECT c FROM Conversations c WHERE c.conversationId = :conversationId")
})
public class Conversations implements Serializable {
    @Id
    @Column(name = "conversation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long conversationId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "users_conversations",
            joinColumns = @JoinColumn(name = "conversation_id"),
            inverseJoinColumns = @JoinColumn(name = "username")
    )
    private List<Users> users = new ArrayList<>();

    public long getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
