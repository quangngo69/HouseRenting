<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Property, java.util.Map, DAO.PropertyImageDAO, java.util.List" %>
<%
    Property p = (Property) request.getAttribute("property");
%>
<html>
<head><title>Property Details</title></head>
<body>
<h2><%= p.getTitle() %></h2>
<img src="<%= p.getImagePath() %>" width="300"/>
<p><%= p.getDescription() %></p>
<p>City: <%= p.getCity() %></p>
<p>Type: <%= p.getType() %></p>
<p>Price: $<%= p.getPrice() %></p>

<form method="post" action="BookPropertyServlet">
    <input type="hidden" name="propertyId" value="<%= p.getId() %>"/>
    <input type="submit" value="Book This Property"/>
</form>
</body>
</html>
<%
    List<Map<String, Object>> images = imageDAO.getImageInfoByProperty(propertyId);
    for (Map<String, Object> img : images) {
        int imgId = (int) img.get("id");
        String url = (String) img.get("url");
%>
    <div style="display:inline-block; margin:5px;">
        <img src="<%= request.getContextPath() + "/" + url %>" width="200" height="150"/><br/>
        <form action="deleteImage" method="post" style="margin-top:5px;">
            <input type="hidden" name="imageId" value="<%= imgId %>"/>
            <input type="hidden" name="propertyId" value="<%= propertyId %>"/>
            <input type="submit" value="Delete" onclick="return confirm('Delete this image?');"/>
        </form>
    </div>
<% } %>
