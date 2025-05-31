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
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.math.BigDecimal;


@WebServlet("/addProperty")
public class AddPropertyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User landlord = (User) session.getAttribute("user");

        Property property = new Property();
        property.setLandlordId(landlord.getUserId());
        property.setTitle(request.getParameter("title"));
        property.setDescription(request.getParameter("description"));
        property.setPrice(new BigDecimal(request.getParameter("price")));
        property.setDistrict(request.getParameter("district"));
        property.setStreet(request.getParameter("street"));
        property.setTown(request.getParameter("town"));
        property.setArea(Float.parseFloat(request.getParameter("area")));
        property.setPropertyType(request.getParameter("propertyType"));
        property.setBathroomCount(Integer.parseInt(request.getParameter("bathroomCount")));
        property.setBedroomCount(Integer.parseInt(request.getParameter("bedroomCount")));
        property.setAvailableFrom(Date.valueOf(request.getParameter("availableFrom")));

        try (Connection conn = DBConnection.getConnection()) {
            PropertyDAO dao = new PropertyDAO(conn);
            dao.addProperty(property);
            response.sendRedirect("landlordDashboard.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    
}
