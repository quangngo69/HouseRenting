package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/views/*") // Protect all files inside /views
public class SecurityFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean loginRequest = request.getRequestURI().endsWith("login.jsp") || request.getRequestURI().endsWith("login");

        if (loggedIn || loginRequest) {
            chain.doFilter(req, res); // Continue
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp"); // Block access
        }
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
