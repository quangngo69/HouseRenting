package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import DAO.UserDAO;
import DAO.DBConnection;
import DAO.PropertyDAO;

@WebServlet("/makePayment")
public class MakePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int propertyId = Integer.parseInt(request.getParameter("propertyId"));
        BigDecimal rentAmount = new BigDecimal(request.getParameter("rentAmount")); // pass this from JSP
        HttpSession session = request.getSession();
        User tenant = (User) session.getAttribute("user");

        try (Connection conn = DBConnection.getConnection()) {
            UserDAO userDAO = new UserDAO(conn);
            PropertyDAO propertyDAO = new PropertyDAO(conn);

            BigDecimal currentBalance = userDAO.getUserBalance(tenant.getUserId());

            if (currentBalance.compareTo(rentAmount) >= 0) {
                BigDecimal newBalance = currentBalance.subtract(rentAmount);
                userDAO.updateUserBalance(tenant.getUserId(), newBalance);
                tenant.setBalance(newBalance);
                session.setAttribute("user", tenant);

                // ✅ Mark the property as booked
                propertyDAO.markPropertyAsBooked(propertyId, tenant.getUserId());


                // (Optional: Add a payment transaction log table)

                response.sendRedirect("paymentSuccess.jsp");
            } else {
                response.sendRedirect("insufficientFunds.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }
}

