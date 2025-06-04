<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Property" %>
<%
    Property p = (Property) request.getAttribute("property");
    if (p == null) {
%>
<h2>Error: Property not found</h2>
<a href="<%= request.getContextPath()%>/propertyList">Back to Dashboard</a>
<%
        return;
    }
%>
<html>
    <head><title>Property Details</title></head>
    <body>
        <h2><%= p.getTitle()%></h2>
        <img src="<%= request.getContextPath() + "/images/uploads/" + p.getImageFilename()%>" width="300"/>
        <p><%= p.getDescription()%></p>
        <p>City: <%= p.getTown()%></p>
        <p>Type: <%= p.getPropertyType()%></p>
        <p>Price: $<%= p.getPrice()%></p>

        <form action="makePayment" method="post">
            <input type="hidden" name="propertyId" value="<%= p.getPropertyId()%>"/>
            <input type="hidden" name="rentAmount" value="<%= p.getPrice()%>"/>
            <input type="submit" value="Pay & Book"/>
        </form>
    </body>
</html>
