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
import DAO.RentingDAO;
import java.sql.Date;
import model.User;
import model.Renting;

@WebServlet("/bookProperty")
public class BookPropertyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int propertyId = Integer.parseInt(request.getParameter("propertyId"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        HttpSession session = request.getSession();
        User tenant = (User) session.getAttribute("user");

        Renting renting = new Renting();
        renting.setPropertyId(propertyId);
        renting.setTenantId(tenant.getUserId());
        renting.setStartDate(startDate);
        renting.setEndDate(endDate);

        try (Connection conn = DBConnection.getConnection()) {
            RentingDAO dao = new RentingDAO(conn);
            dao.bookProperty(renting);
            response.sendRedirect("tenantDashboard.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
