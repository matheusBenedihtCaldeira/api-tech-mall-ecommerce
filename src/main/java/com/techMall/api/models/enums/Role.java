package com.techMall.api.models.enums;

public enum Role {
    ADMIN("admin"),
    RESOURCES("resources"),
    OPERATOR("operator"),
    CUSTOMER("customer");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}