package com.placement.management.entity;

public class User {

    private final int userId;
    private final String username;
    private final long contactNo;
    private final String stream;

    public User(int userId, String username, long contactNo, String stream) {
        this.userId = userId;
        this.username = username;
        this.contactNo = contactNo;
        this.stream = stream;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public long getContactNo() {
        return contactNo;
    }

    public String getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", username='" + username + "', contactNo=" + contactNo
                + ", stream='" + stream + "'}";
    }
}
