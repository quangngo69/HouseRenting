package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.DBConnection;
import java.io.File;
import java.nio.file.Paths;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;
import DAO.PropertyImageDAO;
import model.User;

@WebServlet("/uploadImage")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadImageServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "images/uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !"landlord".equals(user.getUserType())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Only landlords can upload images.");
            return;
        }
        int propertyId = Integer.parseInt(request.getParameter("propertyId"));

        // Upload path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        // Get uploaded file
        Part filePart = request.getPart("imageFile");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Image URL saved in DB (relative)
        String imageUrl = UPLOAD_DIR + "/" + fileName;

        // Save to DB
        try (Connection conn = DBConnection.getConnection()) {
            PropertyImageDAO dao = new PropertyImageDAO(conn);
            dao.saveImage(propertyId, imageUrl);
            response.getWriter().println("Image uploaded successfully!");
        } catch (SQLException e) {
            throw new ServletException("DB error: " + e.getMessage(), e);
        }
    }
}
