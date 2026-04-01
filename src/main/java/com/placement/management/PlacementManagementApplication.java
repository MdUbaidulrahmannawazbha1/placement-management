package com.placement.management;

import com.placement.management.service.PlacementService;
import java.util.Scanner;

public class PlacementManagementApplication {

    private final Scanner scanner = new Scanner(System.in);
    private final PlacementService placementService = new PlacementService();

    public static void main(String[] args) {
        new PlacementManagementApplication().start();
    }

    private void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. User Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> runAdminMenu();
                case 2 -> runUserMenu();
                case 3 -> {
                    running = false;
                    System.out.println("Exiting Application.");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void runAdminMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Admin");
            System.out.println("2. Add Placement");
            System.out.println("3. Add Certificate");
            System.out.println("4. View Placements");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter admin id: ");
                    int id = readInt();
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter contact no: ");
                    long contact = readLong();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    placementService.addAdmin(id, username, contact, role);
                }
                case 2 -> {
                    System.out.print("Enter placement id: ");
                    int placementId = readInt();
                    System.out.print("Enter user id: ");
                    int userId = readInt();
                    System.out.print("Enter admin id: ");
                    int adminId = readInt();
                    System.out.print("Enter company name: ");
                    String company = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    placementService.addPlacement(placementId, userId, adminId, company, status);
                }
                case 3 -> {
                    System.out.print("Enter certificate id: ");
                    int certificateId = readInt();
                    System.out.print("Enter user id: ");
                    int userId = readInt();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter issuer: ");
                    String issuer = scanner.nextLine();
                    placementService.addCertificate(certificateId, userId, title, issuer);
                }
                case 4 -> placementService.printAllPlacements();
                case 5 -> inMenu = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void runUserMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Add User");
            System.out.println("2. View Certificates By User");
            System.out.println("3. View Placements By User");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter user id: ");
                    int id = readInt();
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter contact no: ");
                    long contact = readLong();
                    System.out.print("Enter stream: ");
                    String stream = scanner.nextLine();
                    placementService.addUser(id, username, contact, stream);
                }
                case 2 -> {
                    System.out.print("Enter user id: ");
                    int userId = readInt();
                    placementService.printCertificatesByUser(userId);
                }
                case 3 -> {
                    System.out.print("Enter user id: ");
                    int userId = readInt();
                    placementService.printPlacementsByUser(userId);
                }
                case 4 -> inMenu = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private int readInt() {
        int value = Integer.parseInt(scanner.nextLine());
        return value;
    }

    private long readLong() {
        long value = Long.parseLong(scanner.nextLine());
        return value;
    }
}
