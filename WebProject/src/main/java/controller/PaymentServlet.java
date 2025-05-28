package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.DBConnection;
import model.RentalPayment;
import DAO.PaymentDAO;


@WebServlet("/payRent")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rentingId = Integer.parseInt(request.getParameter("rentingId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        double commission = amount *0.1; // 10% commission

        RentalPayment payment = new RentalPayment();
        payment.setRentingId(rentingId);
        payment.setTotalAmount(amount);
        payment.setCommissionAmount(commission);
        payment.setStatus("paid");
        payment.setPaidDay(new java.sql.Date(System.currentTimeMillis()));

        try (Connection conn = DBConnection.getConnection()) {
            PaymentDAO dao = new PaymentDAO(conn);
            dao.recordPayment(payment);
            response.sendRedirect("tenantDashboard.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

