package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.DBConnection;
import DAO.PropertyDAO;
import model.Property;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminApproval")
public class AdminApprovalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);

            // Fetch pending properties
            List<Property> pendingProperties = dao.getPendingProperties();
            request.setAttribute("pendingProperties", pendingProperties);

            // Forward to JSP
            request.getRequestDispatcher("views/adminApproval.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error while fetching pending properties.");
            response.sendError(500);
        }
    }
}
