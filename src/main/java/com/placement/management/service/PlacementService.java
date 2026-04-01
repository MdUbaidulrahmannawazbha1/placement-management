package com.placement.management.service;

import com.placement.management.entity.Admin;
import com.placement.management.entity.Certificate;
import com.placement.management.entity.Placement;
import com.placement.management.entity.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlacementService {
    private final Map<Integer, User> users = new LinkedHashMap<>();
    private final Map<Integer, Admin> admins = new LinkedHashMap<>();
    private final Map<Integer, Placement> placements = new LinkedHashMap<>();
    private final List<Certificate> certificates = new ArrayList<>();

    public void addUser(int userId, String username, long contactNo, String stream) {
        if (users.containsKey(userId)) {
            System.out.println("User id already exists.");
            return;
        }
        users.put(userId, new User(userId, username, contactNo, stream));
        System.out.println("User created successfully.");
    }

    public void addAdmin(int adminId, String username, long contactNo, String role) {
        if (admins.containsKey(adminId)) {
            System.out.println("Admin id already exists.");
            return;
        }
        admins.put(adminId, new Admin(adminId, username, contactNo, role));
        System.out.println("Admin created successfully.");
    }

    public void addPlacement(int placementId, int userId, int adminId, String companyName, String status) {
        if (placements.containsKey(placementId)) {
            System.out.println("Placement id already exists.");
            return;
        }
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        Admin admin = admins.get(adminId);
        if (admin == null) {
            System.out.println("Admin not found.");
            return;
        }
        placements.put(placementId, new Placement(placementId, user, admin, companyName, status));
        System.out.println("Placement added successfully.");
    }

    public void addCertificate(int certificateId, int userId, String title, String issuer) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        for (Certificate certificate : certificates) {
            if (certificate.getCertificateId() == certificateId) {
                System.out.println("Certificate id already exists.");
                return;
            }
        }
        certificates.add(new Certificate(certificateId, title, issuer, user));
        System.out.println("Certificate added successfully.");
    }

    public void printPlacementsByUser(int userId) {
        boolean found = false;
        for (Placement placement : placements.values()) {
            if (placement.getUser().getUserId() == userId) {
                System.out.println(placement);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No placements found for user.");
        }
    }

    public void printCertificatesByUser(int userId) {
        boolean found = false;
        for (Certificate certificate : certificates) {
            if (certificate.getUser().getUserId() == userId) {
                System.out.println(certificate);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No certificates found for user.");
        }
    }

    public void printAllPlacements() {
        if (placements.isEmpty()) {
            System.out.println("No placements available.");
            return;
        }
        for (Placement placement : placements.values()) {
            System.out.println(placement);
        }
    }
}
