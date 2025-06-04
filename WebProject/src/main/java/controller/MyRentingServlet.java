package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.RentingDAO;
import DAO.DBConnection;
import model.Renting;
import model.User;

@WebServlet("/myRentings")
public class MyRentingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        if (user == null || user.getUserType() == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            RentingDAO rentingDAO = new RentingDAO(conn);
            List<Renting> rentings = rentingDAO.getBookingsByTenant(user.getUserId());
            request.setAttribute("bookings", rentings); // still "bookings" for compatibility with JSP
            request.getRequestDispatcher("/views/myRentings.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error loading renting records", e);
        }
    }
}
