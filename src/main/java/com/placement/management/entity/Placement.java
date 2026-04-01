package com.placement.management.entity;

public class Placement {

    private final int placementId;
    private final User user;
    private final Admin admin;
    private final String companyName;
    private String status;

    public Placement(int placementId, User user, Admin admin, String companyName, String status) {
        this.placementId = placementId;
        this.user = user;
        this.admin = admin;
        this.companyName = companyName;
        this.status = status;
    }

    public int getPlacementId() {
        return placementId;
    }

    public User getUser() {
        return user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Placement{placementId=" + placementId + ", user=" + user.getUsername()
                + ", admin=" + admin.getUsername() + ", companyName='" + companyName
                + "', status='" + status + "'}";
    }
}
