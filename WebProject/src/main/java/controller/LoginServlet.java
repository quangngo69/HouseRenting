/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import DAO.UserDAO;
import DAO.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            UserDAO dao = new UserDAO(conn);
            User user = dao.login(username, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60 * 60 * 24);
                session.setAttribute("user", user);
                request.getRequestDispatcher("/views/dashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp?error=true");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}