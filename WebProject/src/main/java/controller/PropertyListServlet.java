package controller;

import model.Property;
import DAO.PropertyDAO;
import DAO.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/propertyList")
public class PropertyListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO propertyDAO = new PropertyDAO(conn);
            List<Property> properties = propertyDAO.getAllProperties();  // Load from DB

            request.setAttribute("properties", properties);
            request.getRequestDispatcher("/views/propertyList.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Database error while loading properties", e);
        }
    }
}
