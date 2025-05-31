<%@ page import="java.util.*, model.Property" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Pending Properties</title></head>
<body>
<h2>Pending Properties</h2>
<table border="1">
<tr><th>Title</th><th>Town</th><th>Price</th><th>Action</th></tr>
<%
    List<Property> props = (List<Property>) request.getAttribute("pendingProperties");
    for (Property p : props) {
%>
<tr>
    <td><%= p.getTitle() %></td>
    <td><%= p.getTown() %></td>
    <td><%= p.getPrice() %></td>
    <td>
        <form method="post" action="approveProperty">
            <input type="hidden" name="propertyId" value="<%= p.getPropertyId() %>"/>
            <input type="submit" value="Approve"/>
        </form>
    </td>
</tr>
<% } %>
</table>
</body>
</html>
