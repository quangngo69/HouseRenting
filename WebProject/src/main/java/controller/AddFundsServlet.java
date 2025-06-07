package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import DAO.DBConnection;
import DAO.UserDAO;
import model.User;

@WebServlet("/addFunds")
public class AddFundsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String amountStr = request.getParameter("amount");

        try {
            BigDecimal amount = new BigDecimal(amountStr);
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal currentBalance = user.getBalance();
                if (currentBalance == null) {
                    currentBalance = BigDecimal.ZERO;
                }

                BigDecimal newBalance = currentBalance.add(amount);
                user.setBalance(newBalance);

                // Save to DB
                try (Connection conn = DBConnection.getConnection()) {
                    UserDAO dao = new UserDAO(conn);
                    dao.updateUserBalance(user.getUserId(), newBalance);
                }

                session.setAttribute("user", user);
                response.sendRedirect("views/dashboard.jsp");
            } else {
                response.sendRedirect("addFunds.jsp?error=Invalid amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addFunds.jsp?error=Something went wrong");
        }
    }
}
