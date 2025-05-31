<%@ page session="true" %>
<%@ page import="model.Property" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Property property = (Property) request.getAttribute("property");
%>
<html>
<head><title>Edit Property</title></head>
<body>
<h2>Edit Property</h2>
<form method="post" action="EditPropertyServlet">
    <input type="hidden" name="id" value="<%= property.getId() %>"/>
    Title: <input type="text" name="title" value="<%= property.getTitle() %>" required/><br/>
    Description: <textarea name="description"><%= property.getDescription() %></textarea><br/>
    Price: <input type="number" name="price" value="<%= property.getPrice() %>" required/><br/>
    City: <input type="text" name="city" value="<%= property.getCity() %>" required/><br/>
    Type:
    <select name="type">
        <option value="House" <%= property.getType().equals("House") ? "selected" : "" %>>House</option>
        <option value="Apartment" <%= property.getType().equals("Apartment") ? "selected" : "" %>>Apartment</option>
    </select><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
