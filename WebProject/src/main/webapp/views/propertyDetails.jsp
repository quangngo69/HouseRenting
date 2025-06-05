<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.User" %>
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

    User user = (User) session.getAttribute("user");
    String usertype = (user != null && user.getUserType() != null) ? user.getUserType().name() : "";
%>

<html>
    <head><title>Property Details</title></head>
    <body>
        <h2><%= p.getTitle()%></h2>
        <img src="<%= request.getContextPath() + "/images/uploads/" + p.getImageFilename()%>" width="300" />

        <p><strong>Description:</strong> <%= p.getDescription()%></p>
        <p><strong>City:</strong> <%= p.getTown()%></p>
        <p><strong>District:</strong> <%= p.getDistrict()%></p>
        <p><strong>Street:</strong> <%= p.getStreet()%></p>
        <p><strong>Area:</strong> <%= p.getArea()%> m²</p>
        <p><strong>Type:</strong> <%= p.getPropertyType()%></p>
        <p><strong>Bedrooms:</strong> <%= p.getBedroomCount()%></p>
        <p><strong>Bathrooms:</strong> <%= p.getBathroomCount()%></p>
        <p><strong>Available From:</strong> <%= p.getAvailableFrom()%></p>
        <p><strong>Posted On:</strong> <%= p.getCreateDate()%></p>
        <p><strong>Price:</strong> $<%= p.getPrice()%></p>

        <% if ("ADMIN".equals(usertype)) { %>

        <% } else if ("LANDLORD".equals(usertype)) { %>

        <% } else if ("TENANT".equals(usertype)) {%>
        <form action="makePayment" method="post">
            <input type="hidden" name="propertyId" value="<%= p.getPropertyId()%>" />
            <input type="hidden" name="rentAmount" value="<%= p.getPrice()%>" />
            <input type="submit" value="Pay & Book" /><br>
            <a href="${pageContext.request.contextPath}/propertyList">Back</a>
        </form>
        <% }%>
       
    </body>
</html>
