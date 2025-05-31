/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class PropertyImageDAO {
    private Connection conn;

    public PropertyImageDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean saveImage(int propertyId, String imageUrl) throws SQLException {
        String sql = "INSERT INTO propertyimages (property_id, image_url, upload_date) VALUES (?, ?, CURDATE())";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, propertyId);
            stmt.setString(2, imageUrl);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<String> getImagesByProperty(int propertyId) throws SQLException {
        String sql = "SELECT image_url FROM propertyimages WHERE property_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, propertyId);
            ResultSet rs = stmt.executeQuery();
            List<String> images = new ArrayList<>();
            while (rs.next()) {
                images.add(rs.getString("image_url"));
            }
            return images;
        }
    }
    
    public boolean deleteImage(int imageId) throws SQLException {
    String sql = "DELETE FROM propertyimages WHERE image_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, imageId);
        return stmt.executeUpdate() > 0;
    }
}

public String getImagePathById(int imageId) throws SQLException {
    String sql = "SELECT image_url FROM propertyimages WHERE image_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, imageId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("image_url");
        }
    }
    return null;
}

public List<Map<String, Object>> getImageInfoByProperty(int propertyId) throws SQLException {
    String sql = "SELECT image_id, image_url FROM propertyimages WHERE property_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, propertyId);
        ResultSet rs = stmt.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> img = new HashMap<>();
            img.put("id", rs.getInt("image_id"));
            img.put("url", rs.getString("image_url"));
            list.add(img);
        }
        return list;
    }
}


}

