<%@ page import="java.util.List, model.Property" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Property> results = (List<Property>) request.getAttribute("results");
%>
<html>
<head><title>Search Results</title></head>
<body>
<h2>Search Results</h2>
<%
    if (results != null && !results.isEmpty()) {
        for (Property p : results) {
%>
    <div style="border:1px solid #ccc; padding:10px;">
        <strong><%= p.getTitle() %></strong> - $<%= p.getPrice() %><br/>
        <%= p.getCity() %> | <%= p.getType() %><br/>
        <a href="propertyDetails.jsp?id=<%= p.getId() %>">View Details</a>
        <hr/>
    </div>
<%
        }
    } else {
%>
    <p>No results found for your query.</p>
<%
    }
%>
<a href="propertyList.jsp">Back to All Properties</a>
</body>
</html>
