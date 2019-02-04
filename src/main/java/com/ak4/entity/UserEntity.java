package com.ak4.entity;

import javax.persistence.*;
import java.util.Set;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @Column(name = "USER_ID")
    private String userId = randomUUID().toString();

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "ACTIVE")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<RoleEntity> roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
