<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Browse Properties</title></head>
<body>
<h2>Available Properties</h2>
<form method="get" action="propertyList">
    City: <input type="text" name="city"/>
    Min Price: <input type="number" name="minPrice"/>
    Max Price: <input type="number" name="maxPrice"/>
    Type:
    <select name="type">
        <option value="">Any</option>
        <option value="House">House</option>
        <option value="Apartment">Apartment</option>
    </select>
    Sort:
    <select name="sort">
        <option value="">Default</option>
        <option value="priceAsc">Price Ascending</option>
        <option value="recent">Most Recent</option>
    </select>
    <input type="submit" value="Search"/>
    <button type="button" onclick="window.location.href='propertyList'">Reset Filters</button>
</form>

<%-- Loop through property list --%>
<% 
    List<Property> properties = (List<Property>) request.getAttribute("properties");
    for (Property p : properties) {
%>
    <div style="border:1px solid #ccc; margin:10px; padding:10px;">
        <img src="<%= p.getImagePath() %>" width="100"/>
        <h3><%= p.getTitle() %> - $<%= p.getPrice() %></h3>
        <p><%= p.getCity() %> - <%= p.getType() %></p>
        <a href="propertyDetails.jsp?id=<%= p.getId() %>">View Details</a>
    </div>
<% } %>
</body>
</html>
