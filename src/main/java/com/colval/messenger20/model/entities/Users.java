package com.colval.messenger20.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
})
public class Users implements Serializable {

    @Column(name = "first_name")
    @NotEmpty(message = "First name can not be empty")
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name can not be empty")
    @Size(max = 100)
    private String lastName;

    @Id
    @Column(name = "username")
    @NotEmpty(message = "Username can not be empty")
    @Size(max = 100)
    private String username;

    @Column(name="password")
    @NotBlank(message = "Password can not be blank")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(mappedBy = "users")
    private List<Conversations> conversations = new ArrayList<>();

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Conversations> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversations> conversations) {
        this.conversations = conversations;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
