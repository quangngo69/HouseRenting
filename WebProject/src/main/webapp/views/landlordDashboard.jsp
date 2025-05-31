<%@ page session="true" %>
<%@ page import="java.util.List, model.Property" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Property> properties = (List<Property>) request.getAttribute("properties");
    String username = (String) session.getAttribute("username");
%>
<html>
<head><title>Landlord Dashboard</title></head>
<body>
<h2>Welcome, <%= username %> – Your Listed Properties</h2>
<a href="addProperty.jsp">Add New Property</a><br/><br/>

<%
    if (properties != null && !properties.isEmpty()) {
        for (Property p : properties) {
%>
    <div style="border:1px solid #ccc; margin:10px; padding:10px;">
        <img src="<%= p.getImagePath() %>" width="100"/><br/>
        <strong><%= p.getTitle() %></strong> - $<%= p.getPrice() %><br/>
        <%= p.getCity() %> | <%= p.getType() %><br/>
        <a href="editProperty.jsp?id=<%= p.getId() %>">Edit</a> |
        <a href="uploadImage.jsp?id=<%= p.getId() %>">Upload Image</a> |
        <a href="DeletePropertyServlet?id=<%= p.getId() %>">Delete</a>
    </div>
<%
        }
    } else {
%>
    <p>You have not listed any properties yet.</p>
<% } %>

<a href="LogoutServlet">Logout</a>
</body>
</html>
