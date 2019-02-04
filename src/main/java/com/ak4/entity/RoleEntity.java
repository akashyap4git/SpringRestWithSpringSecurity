package com.ak4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "ROLES")
public class RoleEntity {

    @Id
    @Column(name = "ROLE_ID")
    private String roleId = randomUUID().toString();

    @Column(name = "ROLE")
    private String role;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
