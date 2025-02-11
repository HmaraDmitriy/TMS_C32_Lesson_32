package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetup {
    public static void createTables() {
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS second (
                id SERIAL PRIMARY KEY,
                login VARCHAR(50) NOT NULL,
                password VARCHAR(255) NOT NULL,
                description TEXT,
                age INTEGER,
                is_active BOOLEAN DEFAULT TRUE
            );
        """;

        String createTasksTable = """
            CREATE TABLE IF NOT EXISTS task (
                id SERIAL PRIMARY KEY,
                user_id INTEGER NOT NULL,
                title VARCHAR(100) NOT NULL,
                description TEXT,
                status VARCHAR(20) DEFAULT 'new',
                created_at TIMESTAMP DEFAULT NOW(),
                FOREIGN KEY (user_id) REFERENCES second(id) ON DELETE CASCADE
            );
        """;

        try (Connection conn = DataBaseTest.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createUsersTable);
            stmt.execute(createTasksTable);

            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }
}
