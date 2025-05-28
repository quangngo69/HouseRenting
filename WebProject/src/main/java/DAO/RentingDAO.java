package DAO;

import model.Renting;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class RentingDAO {
    private Connection conn;

    public RentingDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean bookProperty(Renting renting) throws SQLException {
        String sql = "INSERT INTO renting (property_id, tenant_id, status, book_date, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, renting.getPropertyId());
            stmt.setInt(2, renting.getTenantId());
            stmt.setString(3, "booked");
            stmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            stmt.setDate(5, new java.sql.Date(renting.getStartDate().getTime()));
            stmt.setDate(6, new java.sql.Date(renting.getEndDate().getTime()));
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Renting> getBookingsByTenant(int tenantId) throws SQLException {
        String sql = "SELECT * FROM renting WHERE tenant_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tenantId);
            ResultSet rs = stmt.executeQuery();
            List<Renting> list = new ArrayList<>();
            while (rs.next()) {
                Renting r = new Renting();
                r.setRentId(rs.getInt("rent_id"));
                r.setPropertyId(rs.getInt("property_id"));
                r.setStatus(Renting.RentingStatus.fromString(rs.getString("status")));
                r.setBookDate(rs.getDate("book_date"));
                r.setStartDate(rs.getDate("start_date"));
                r.setEndDate(rs.getDate("end_date"));
                list.add(r);
            }
            return list;
        }
    }
}
