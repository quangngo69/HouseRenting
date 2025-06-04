<%@ page import="model.User" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    User user = (User) session.getAttribute("user");
    String username = user != null ? user.getUsername() : "Guest";
    String usertype = user != null && user.getUserType() != null ? user.getUserType().name() : "Unknown";
%>
<html>
    <head><title>Dashboard</title></head>
    <body>
        <h2>Welcome, <%= username %> (<%= usertype %>)</h2>

        <% if ("ADMIN".equals(usertype)) { %>
        <a href="${pageContext.request.contextPath}/adminApproval">Pending Approvals</a>
        <% } else if ("LANDLORD".equals(usertype)) { %>
        <a href="${pageContext.request.contextPath}/views/addProperty.jsp">Add Property</a><br/>
        <a href="${pageContext.request.contextPath}/myProperties">My Properties</a>
        <% } else if ("TENANT".equals(usertype)) { %>
        <a href="${pageContext.request.contextPath}/propertyList">Browse Properties</a><br/>
        <a href="${pageContext.request.contextPath}/myRentings">My Renting</a><br/>
        <% } %>

        <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
    </body>
</html>
