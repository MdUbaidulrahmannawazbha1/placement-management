package com.placement.management.entity;

public class Admin extends User {
    private final String role;

    public Admin(int userId, String username, long contactNo, String role) {
        super(userId, username, contactNo, "ADMIN");
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Admin{userId=" + getUserId() + ", username='" + getUsername() + "', role='" + role + "'}";
    }
}
