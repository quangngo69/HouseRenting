package controller;
import model.User;
import java.io.IOException;
import DAO.UserDAO;
import java.sql.SQLException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        User user = new User();
        user.setFullname(fullname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setUserType(User.UserType.fromString(userType));
        

        try (Connection conn = DBConnection.getConnection()) {
            UserDAO dao = new UserDAO(conn);
            if (dao.registerUser(user)) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("register.jsp?error=true");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
