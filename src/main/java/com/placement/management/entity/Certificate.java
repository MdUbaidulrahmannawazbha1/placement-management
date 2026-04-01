package com.placement.management.entity;

public class Certificate {

    private final int certificateId;
    private final String title;
    private final String issuer;
    private final User user;

    public Certificate(int certificateId, String title, String issuer, User user) {
        this.certificateId = certificateId;
        this.title = title;
        this.issuer = issuer;
        this.user = user;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public String getTitle() {
        return title;
    }

    public String getIssuer() {
        return issuer;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Certificate{certificateId=" + certificateId + ", title='" + title
                + "', issuer='" + issuer + "', user=" + user.getUsername() + "}";
    }
}
