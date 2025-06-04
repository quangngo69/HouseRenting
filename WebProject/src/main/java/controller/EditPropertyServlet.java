package controller;

import DAO.DBConnection;
import DAO.PropertyDAO;
import model.Property;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.math.BigDecimal;

@WebServlet("/editProperty")
public class EditPropertyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int propertyId = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);
            Property property = dao.getPropertyById(propertyId); // You must have this method
            request.setAttribute("property", property);
            request.getRequestDispatcher("/views/editProperty.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int propertyId = Integer.parseInt(request.getParameter("id"));

        Property property = new Property();
        property.setPropertyId(propertyId);
        property.setTitle(request.getParameter("title"));
        property.setDescription(request.getParameter("description"));
        property.setPrice(new BigDecimal(request.getParameter("price")));
        property.setArea(Float.parseFloat(request.getParameter("area")));
        property.setBedroomCount(Integer.parseInt(request.getParameter("bedroomCount")));
        property.setBathroomCount(Integer.parseInt(request.getParameter("bathroomCount")));
        property.setDistrict(request.getParameter("district"));
        property.setStreet(request.getParameter("street"));
        property.setTown(request.getParameter("town"));
        property.setPropertyType(request.getParameter("type"));

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);
            dao.updateProperty(property); // You must implement this method
            response.sendRedirect("myProperties");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
