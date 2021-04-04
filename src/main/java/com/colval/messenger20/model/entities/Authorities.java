package com.colval.messenger20.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @JoinColumn(name = "username", referencedColumnName = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
