<%@ page import="model.User" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    User user = (User) session.getAttribute("user");
    String username = user != null ? user.getUsername() : "Admin";
%>
<header>
<!--    <div class="header-left-buttons">
        <a href="${pageContext.request.contextPath}/pendingProperties" class="logout2">View Pending Properties</a>
    </div>-->
    
    <div class="container">
        <div class="header-info">
            <h1 class="header-headline">Welcome, <%= username %></h1>
            <p class="header-subtitle">Admin Dashboard</p>
        </div>
        <div style="position: absolute; top: 20px; right: 30px;">
            <a href="${pageContext.request.contextPath}/LogoutServlet" class="logout">Logout</a>
        </div>
    </div>
</header>
