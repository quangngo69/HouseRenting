/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.DBConnection;
import java.io.File;
import DAO.PropertyImageDAO;
import model.User;

@WebServlet("/deleteImage")
public class DeleteImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !"landlord".equals(user.getUserType())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Only landlords can delete images.");
            return;
        }
        int imageId = Integer.parseInt(request.getParameter("imageId"));
        try (Connection conn = DBConnection.getConnection()) {
            PropertyImageDAO dao = new PropertyImageDAO(conn);
            String path = dao.getImagePathById(imageId);
            if (dao.deleteImage(imageId)) {
                // Delete file from disk
                String fullPath = getServletContext().getRealPath("") + File.separator + path;
                File file = new File(fullPath);
                if (file.exists()) file.delete();
            }
            // Redirect back to property details
            int propertyId = Integer.parseInt(request.getParameter("propertyId"));
            response.sendRedirect("propertyDetails.jsp?propertyId=" + propertyId);
        } catch (SQLException e) {
            throw new ServletException("Delete failed: " + e.getMessage(), e);
        }
    }
}
