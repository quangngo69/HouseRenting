package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.PropertyDAO;
import DAO.DBConnection;
import model.Property;
import model.User;

@WebServlet("/myRentings")
public class MyRentingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        if (user == null || user.getUserType() == null || !"TENANT".equals(user.getUserType().name())) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO propertyDAO = new PropertyDAO(conn);

            // Get all properties booked (status = 0) by this tenant
            List<Property> lists = propertyDAO.getPropertiesBookedByTenant(user.getUserId());

            request.setAttribute("bookedProperties", lists);
            request.getRequestDispatcher("/views/myRentings.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Error retrieving booked properties", e);
        }
    }
}
