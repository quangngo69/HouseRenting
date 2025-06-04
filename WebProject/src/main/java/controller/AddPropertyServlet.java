package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import model.Property;
import model.User;
import DAO.DBConnection;
import DAO.PropertyDAO;

@WebServlet("/addProperty")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,    // 1MB
                 maxFileSize = 1024 * 1024 * 5,      // 5MB
                 maxRequestSize = 1024 * 1024 * 10)  // 10MB
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

        // ✅ Image Upload Handling
        Part imagePart = request.getPart("propertyImage");
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

        if (fileName != null && !fileName.isEmpty()) {
            // ✅ Runtime path (deployed build)
            String runtimeUploadPath = getServletContext().getRealPath("/images/uploads");

            // ✅ Source code path (for GitHub/IDE)
            String projectUploadPath = "C:/Users/huynh/OneDrive/Documents/GitHub/HouseRenting/WebProject/src/main/webapp/images/uploads";

            // Create both folders if they don't exist
            new File(runtimeUploadPath).mkdirs();
            new File(projectUploadPath).mkdirs();

            // Save to runtime build folder
            try (InputStream input = imagePart.getInputStream()) {
                Files.copy(input, new File(runtimeUploadPath, fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            // Save to source code folder
            try (InputStream input2 = imagePart.getInputStream()) {
                Files.copy(input2, new File(projectUploadPath, fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            System.out.println("Uploaded to: " + runtimeUploadPath + " and " + projectUploadPath);

            // ✅ Save filename to property object
            property.setImageFilename(fileName);
        }

        // ✅ Save property to database
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
