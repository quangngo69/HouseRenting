<%@ page import="model.User" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    User user = (User) session.getAttribute("user");
    String username = user != null ? user.getUsername() : "Landlord";
%>
<div class="header">
    <div class="container">
        <div class="header-info">
            <h1 class="header-headline">Welcome, <%= username %></h1>
            <p class="header-subtitle">Landlord Dashboard</p>
        </div>
        <div style="position: absolute; top: 20px; right: 30px;">
            <a href="${pageContext.request.contextPath}/LogoutServlet" 
               style="color: white; text-decoration: none; font-weight: bold;">Logout</a>
        </div>
    </div>
</div>