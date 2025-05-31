<%@ page import="java.util.List, model.Tenant" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Tenant> tenants = (List<Tenant>) request.getAttribute("tenants");
%>
<html>
<head><title>View Tenants</title></head>
<body>
<h2>Tenants for Property</h2>
<table border="1">
    <tr>
        <th>Full Name</th>
        <th>Username</th>
        <th>Contact</th>
        <th>Status</th>
    </tr>
<%
    for (Tenant t : tenants) {
%>
    <tr>
        <td><%= t.getFullname() %></td>
        <td><%= t.getUsername() %></td>
        <td><%= t.getContact() %></td>
        <td><%= t.getStatus() %></td>
    </tr>
<% } %>
</table>
</body>
</html>
