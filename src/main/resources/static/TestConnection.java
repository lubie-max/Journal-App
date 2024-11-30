package dev.lubna.JA.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void connection(String[] args) {
        String jdbcUrl = "jdbc:mysql://sql309.infinityfree.com:3306/if0_37506694_journal";
        String username = "if0_37506694";
        String password = "adminRoot";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }
}
