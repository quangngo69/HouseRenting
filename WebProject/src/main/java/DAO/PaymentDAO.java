import model.RentalPayment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;




public class PaymentDAO {
    private Connection conn;

    public PaymentDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean recordPayment(RentalPayment payment) throws SQLException {
        String sql = "INSERT INTO rentalpayment (renting_id, total_amount, commission_amount, status, paid_day, create_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, payment.getRentingId());
            stmt.setDouble(2, payment.getTotalAmount());
            stmt.setDouble(3, payment.getCommissionAmount());
            stmt.setString(4, payment.getStatus());
            stmt.setDate(5, new java.sql.Date(payment.getPaidDay().getTime()));
            stmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            return stmt.executeUpdate() > 0;
        }
    }

    public List<RentalPayment> getPaymentsByUser(int tenantId) throws SQLException {
        String sql = "SELECT p.* FROM rentalpayment p JOIN renting r ON p.renting_id = r.rent_id WHERE r.tenant_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tenantId);
            ResultSet rs = stmt.executeQuery();
            List<RentalPayment> list = new ArrayList<>();
            while (rs.next()) {
                RentalPayment pay = new RentalPayment();
                pay.setPaymentId(rs.getInt("payment_id"));
                pay.setTotalAmount(rs.getDouble("total_amount"));
                pay.setStatus(rs.getString("status"));
                pay.setPaidDay(rs.getDate("paid_day"));
                list.add(pay);
            }
            return list;
        }
    }
}
