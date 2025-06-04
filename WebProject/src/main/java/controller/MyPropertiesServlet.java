package controller;

import model.Property;
import model.User;
import DAO.PropertyDAO;
import DAO.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/myProperties")
public class MyPropertiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        // Ensure the user is logged in and is a landlord
        if (user == null || user.getUserType() == null || !"LANDLORD".equals(user.getUserType().name())) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);
            List<Property> list = dao.getPropertiesByLandlord(user.getUserId());

            request.setAttribute("properties", list);
            request.getRequestDispatcher("/views/myProperties.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Error retrieving landlord's properties", e);
        }
    }
}
