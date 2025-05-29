package DAO;

import model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;




public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO users(fullname, username, email, phone, password, join_date, user_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getPassword());
            stmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            stmt.setString(7, user.getUserType().name());
            return stmt.executeUpdate() > 0;
        }
    }

    public User login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setUserType(User.UserType.fromString(rs.getString("user_type")));
                return user;
            }
            return null;
        }
    }
}
