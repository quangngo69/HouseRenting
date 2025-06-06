<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.Property" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>My Rented Properties</title>
        <style>
            .property-card {
                border: 1px solid #ccc;
                margin: 10px;
                padding: 10px;
                border-radius: 8px;
                box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
                max-width: 700px;
            }
            .property-card img {
                max-width: 100%;
                height: auto;
            }
        </style>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
    </head>
    <body>
        <h2>My Rented Properties</h2>
        <a href="${pageContext.request.contextPath}/views/dashboard.jsp" class="btn3">Back to Dashboard</a>
        <%
            List<Property> lists = (List<Property>) request.getAttribute("bookedProperties");
            if (lists != null && !lists.isEmpty()) {
                for (Property p : lists) {
        %>
        <div class="property-card">
            <h3><%= p.getTitle() != null ? p.getTitle() : "Untitled"%> - $<%= p.getPrice()%></h3>

            <% if (p.getImageFilename() != null && !p.getImageFilename().isEmpty()) {%>
            <img src="<%= request.getContextPath() + "/images/uploads/" + p.getImageFilename()%>" alt="Property Image" />
            <% } else { %>
            <p><i>No image available.</i></p>
            <% }%>

            <p><strong>Type:</strong> <%= p.getPropertyType() != null ? p.getPropertyType() : "N/A"%></p>
            <p><strong>Location:</strong> 
                <%= p.getTown() != null ? p.getTown() : "?"%>, 
                <%= p.getDistrict() != null ? p.getDistrict() : "?"%>, 
                <%= p.getStreet() != null ? p.getStreet() : "?"%>
            </p>

            <p><strong>Bedrooms:</strong> <%= p.getBedroomCount()%> | 
                <strong>Bathrooms:</strong> <%= p.getBathroomCount()%></p>
<!--            <a href="${pageContext.request.contextPath}/propertyDetails?id=<%= p.getPropertyId() %>" class="btn3">View Details</a>-->
        </div>
        <%
            }
        } else {
        %>
        <p>No rented properties found.</p>
        <% }%>

    </body>
</html>
