<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String username = (String) session.getAttribute("username");
    String usertype = (String) session.getAttribute("usertype");
%>
<html>
<head><title>Dashboard</title></head>
<body>
<h2>Welcome, <%= username %> (<%= usertype %>)</h2>

<% if ("ADMIN".equals(usertype)) { %>
    <a href="adminApproval.jsp">Pending Approvals</a><br/>
<% } else if ("LANDLORD".equals(usertype)) { %>
    <a href="addProperty.jsp">Add Property</a><br/>
    <a href="myProperties.jsp">My Properties</a><br/>
<% } else if ("TENANT".equals(usertype)) { %>
    <a href="propertyList.jsp">Browse Properties</a><br/>
    <a href="myBookings.jsp">My Bookings</a><br/>
<% } %>

<a href="LogoutServlet">Logout</a>
</body>
</html>
