package controller;

import DAO.DBConnection;
import DAO.PropertyDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/DeletePropertyServlet")
public class DeletePropertyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int propertyId = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);
            dao.deleteProperty(propertyId); // You must also implement this method in PropertyDAO
            response.sendRedirect("myProperties");
        } catch (Exception e) {
            throw new ServletException("Failed to delete property", e);
        }
    }
}
