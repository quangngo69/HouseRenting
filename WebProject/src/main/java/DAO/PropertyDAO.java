package DAO;

import model.Property;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {

    private Connection conn;

    public PropertyDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addProperty(Property property) throws SQLException {
        String sql = "INSERT INTO properties (landlord_id, title, description, price, district, street, town, area, property_type, bathroom_count, bedroom_count, approved_status, create_date, available_from, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, property.getLandlordId());
            stmt.setString(2, property.getTitle());
            stmt.setString(3, property.getDescription());
            stmt.setBigDecimal(4, property.getPrice());
            stmt.setString(5, property.getDistrict());
            stmt.setString(6, property.getStreet());
            stmt.setString(7, property.getTown());
            stmt.setDouble(8, property.getArea());
            stmt.setString(9, property.getPropertyType());
            stmt.setInt(10, property.getBathroomCount());
            stmt.setInt(11, property.getBedroomCount());
            stmt.setBoolean(12, false); // Not approved by default
            stmt.setDate(13, new java.sql.Date(System.currentTimeMillis()));
            stmt.setDate(14, new java.sql.Date(property.getAvailableFrom().getTime()));
            stmt.setBoolean(15, true);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Property> getPropertiesByLandlord(int landlordId) throws SQLException {
        String sql = "SELECT * FROM properties WHERE landlord_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, landlordId);
            ResultSet rs = stmt.executeQuery();
            List<Property> list = new ArrayList<>();
            while (rs.next()) {
                Property property = new Property();
                property.setPropertyId(rs.getInt("property_id"));
                property.setTitle(rs.getString("title"));
                property.setDescription(rs.getString("description"));
                property.setPrice(rs.getBigDecimal("price"));
                property.setTown(rs.getString("town"));
                property.setStatus(rs.getBoolean("status"));
                list.add(property);
            }
            return list;
        }
    }

    public List<Property> getPendingProperties() throws SQLException {
        String sql = "SELECT * FROM properties WHERE approved_status = 0";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Property> list = new ArrayList<>();
            while (rs.next()) {
                Property p = new Property();
                p.setPropertyId(rs.getInt("property_id"));
                p.setTitle(rs.getString("title"));
                p.setTown(rs.getString("town"));
                p.setPrice(rs.getBigDecimal("price"));
                p.setApprovedStatus(false);
                list.add(p);
            }
            return list;
        }
    }

    public boolean approveProperty(int propertyId) throws SQLException {
        String sql = "UPDATE properties SET approved_status = 1 WHERE property_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, propertyId);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Property> getAllProperties() throws SQLException {
        List<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM properties WHERE approved_status = 1 AND status = 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Property p = new Property();
                p.setPropertyId(rs.getInt("property_id"));
                p.setLandlordId(rs.getInt("landlord_id"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getBigDecimal("price"));
                p.setDistrict(rs.getString("district"));
                p.setStreet(rs.getString("street"));
                p.setTown(rs.getString("town"));
                p.setArea(rs.getFloat("area"));
                p.setPropertyType(rs.getString("property_type"));
                p.setBathroomCount(rs.getInt("bathroom_count"));
                p.setBedroomCount(rs.getInt("bedroom_count"));
                p.setApprovedStatus(rs.getBoolean("approved_status"));
                p.setCreateDate(rs.getDate("create_date"));
                p.setAvailableFrom(rs.getDate("available_from"));
                p.setStatus(rs.getBoolean("status"));

                properties.add(p);
            }
        }
        return properties;
    }

    public Property getPropertyById(int propertyId) throws SQLException {
        String sql = "SELECT * FROM properties WHERE property_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, propertyId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Property p = new Property();
                p.setPropertyId(rs.getInt("property_id"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getBigDecimal("price"));
                p.setTown(rs.getString("town"));
                p.setPropertyType(rs.getString("property_type"));
                return p;
            }
            return null;
        }
    }

    public boolean updateProperty(Property property) throws SQLException {
        String sql = "UPDATE properties SET title = ?, description = ?, price = ?, town = ?, property_type = ? WHERE property_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, property.getTitle());
            stmt.setString(2, property.getDescription());
            stmt.setBigDecimal(3, property.getPrice());
            stmt.setString(4, property.getTown());
            stmt.setString(5, property.getPropertyType());
            stmt.setInt(6, property.getPropertyId());
            return stmt.executeUpdate() > 0;
        }
    }
    public boolean deleteProperty(int propertyId) throws SQLException {
        String sql = "DELETE FROM properties WHERE property_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, propertyId);
            return stmt.executeUpdate() > 0;
        }
    }
}
