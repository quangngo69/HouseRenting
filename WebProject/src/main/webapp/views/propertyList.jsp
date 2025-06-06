<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Property" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Browse Properties</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
    </head>
    <body>
        <h2 class="browse-form-title">Available Properties</h2>

        <div class="browse-form-actions">
            <a href="${pageContext.request.contextPath}/views/dashboard.jsp" class="btn3">Back to Dashboard</a>
        </div>

        <form method="get" action="propertyList" class="browse-form">
            <table class="browse-form-table">
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="city" class="browse-input" /></td>
                    <td>Min Price:</td>
                    <td><input type="number" name="minPrice" class="browse-input" /></td>
                    <td>Max Price:</td>
                    <td><input type="number" name="maxPrice" class="browse-input" /></td>
                    <td>Type:</td>
                    <td>
                        <select name="type" class="browse-input">
                            <option value="">Any</option>
                            <option value="House">House</option>
                            <option value="Apartment">Apartment</option>
                        </select>
                    </td>
                    <td>Sort:</td>
                    <td>
                        <select name="sort" class="browse-input">
                            <option value="">Default</option>
                            <option value="priceAsc">Price Ascending</option>
                            <option value="recent">Most Recent</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="browse-btn-group">
                <input type="submit" value="Search" class="btn3" />
                <button type="button" class="btn3" onclick="window.location.href = 'propertyList'">Reset Filters</button>
            </div>
        </form>

        <%
            List<Property> properties = (List<Property>) request.getAttribute("properties");
            for (Property p : properties) {
        %>
        <div class="card">
            <h3><%= p.getTitle()%> - $<%= p.getPrice()%></h3>

            <% if (p.getImageFilename() != null && !p.getImageFilename().isEmpty()) {%>
            <img src="<%= request.getContextPath() + "/images/uploads/" + p.getImageFilename()%>" class="card-img" />
            <% } else {%>
            <img src="<%= request.getContextPath() + "/images/default.jpg"%>" class="card-img" />
            <% }%>

            <p><%= p.getTown()%> - <%= p.getPropertyType()%></p>

            <div class="card-actions">
                <a href="${pageContext.request.contextPath}/propertyDetails?id=<%= p.getPropertyId()%>" class="btn3">View Details</a>
            </div>
        </div>
        <% }%>
    </body>
</html>
