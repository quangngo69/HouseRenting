package controller;

import model.Property;
import DAO.DBConnection;
import DAO.PropertyDAO;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.math.BigDecimal;

@WebServlet("/addProperty")
@MultipartConfig
public class AddPropertyServlet extends HttpServlet {

    private String safeParam(HttpServletRequest request, String name) {
        String val = request.getParameter(name);
        return val != null ? val.trim() : "";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User landlord = (User) session.getAttribute("user");

        Property property = new Property();
        property.setLandlordId(landlord.getUserId());
        property.setTitle(safeParam(request, "title"));
        property.setDescription(safeParam(request, "description"));

        try {
            property.setPrice(new BigDecimal(safeParam(request, "price")));
        } catch (NumberFormatException e) {
            property.setPrice(BigDecimal.ZERO);
        }

        property.setDistrict(safeParam(request, "district"));
        property.setStreet(safeParam(request, "street"));
        property.setTown(safeParam(request, "town"));

        try {
            property.setArea(Float.parseFloat(safeParam(request, "area")));
        } catch (NumberFormatException e) {
            property.setArea(0.0f);
        }

        property.setPropertyType(safeParam(request, "propertyType"));

        try {
            property.setBathroomCount(Integer.parseInt(safeParam(request, "bathroomCount")));
        } catch (NumberFormatException e) {
            property.setBathroomCount(0);
        }

        try {
            property.setBedroomCount(Integer.parseInt(safeParam(request, "bedroomCount")));
        } catch (NumberFormatException e) {
            property.setBedroomCount(0);
        }

        try {
            property.setAvailableFrom(Date.valueOf(safeParam(request, "availableFrom")));
        } catch (IllegalArgumentException e) {
            property.setAvailableFrom(new Date(System.currentTimeMillis()));
        }

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);
            boolean success = dao.addProperty(property);
            request.setAttribute("message", success ? "success" : "fail");
            request.getRequestDispatcher("/views/addProperty.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "fail");
            request.getRequestDispatcher("/views/addProperty.jsp").forward(request, response);
        }
    }
}
