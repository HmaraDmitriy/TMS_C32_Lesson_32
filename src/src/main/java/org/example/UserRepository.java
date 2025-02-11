package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static void addUser(DBUser user) {
        String sql = "INSERT INTO second (login, password, description, age, is_active) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getDescription());
            stmt.setInt(4, user.getAge());
            stmt.setBoolean(5, user.isActive());

            stmt.executeUpdate();
            System.out.println("User added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<DBUser> getUsers() {
        List<DBUser> users = new ArrayList<>();
        String sql = "SELECT * FROM second";

        try (Connection conn = DataBaseTest.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new DBUser(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("description"),
                        rs.getInt("age"),
                        rs.getBoolean("is_active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
