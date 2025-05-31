<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Property" %>
<html>
<head><title>My Properties</title></head>
<body>
<h2>My Listed Properties</h2>
<% 
    List<Property> list = (List<Property>) request.getAttribute("properties");
    for (Property p : list) {
%>
    <div>
        <h3><%= p.getTitle() %> - $<%= p.getPrice() %></h3>
        <a href="editProperty.jsp?id=<%= p.getId() %>">Edit</a> | 
        <a href="DeletePropertyServlet?id=<%= p.getId() %>">Delete</a>
    </div>
<% } %>
</body>
</html>
