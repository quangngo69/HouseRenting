<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Property" %>
<html>
    <head>
        <title>My Properties</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
    </head>
    <body>
        <h2 class="form-title">My Listed Properties</h2>
        <div class="form-actions">
            <a href="${pageContext.request.contextPath}/views/dashboard.jsp" class="btn3">Back to Dashboard</a>
        </div>

        <%
            List<Property> list = (List<Property>) request.getAttribute("properties");
            for (Property p : list) {
        %>
        <div class="card">
            <h3><%= p.getTitle() %> - $<%= p.getPrice() %> -
                <span class="<%= p.getStatus() ? "available" : "rented" %>">
                    <%= p.getStatus() ? "Available" : "Rented" %>
                </span>
            </h3>

            <% if (p.getImageFilename() != null && !p.getImageFilename().isEmpty()) { %>
                <img src="<%= request.getContextPath() + "/images/uploads/" + p.getImageFilename() %>" class="card-img" />
            <% } else { %>
                <p><i>No image uploaded.</i></p>
            <% } %>

            <div class="card-actions">
                <a href="${pageContext.request.contextPath}/propertyDetails?id=<%= p.getPropertyId() %>" class="btn3">View Details</a>
                <a href="<%= request.getContextPath() %>/editProperty?id=<%= p.getPropertyId() %>" class="btn3">Edit</a>
                <a href="<%= request.getContextPath() %>/DeletePropertyServlet?id=<%= p.getPropertyId() %>" class="btn3">Delete</a>
            </div>
        </div>
        <% } %>
        
    </body>
</html>
