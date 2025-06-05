<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Property" %>
<html>
    <head><title>My Properties</title></head>
    <body>
        <h2>My Listed Properties</h2>
        <a href="${pageContext.request.contextPath}/views/dashboard.jsp">Back to Dashboard</a>
        <%
            List<Property> list = (List<Property>) request.getAttribute("properties");
            for (Property p : list) {
        %>
        <div>
            <h3><%= p.getTitle()%> - $<%= p.getPrice()%></h3>

            <% if (p.getImageFilename() != null && !p.getImageFilename().isEmpty()) {%>
            <img src="<%= request.getContextPath() + "/images/uploads/" + p.getImageFilename()%>" width="250" />
            <% } else { %>
            <p><i>No image uploaded.</i></p>
            <% }%>

            <br/>
            <a href="${pageContext.request.contextPath}/propertyDetails?id=<%= p.getPropertyId() %>">View Details</a>
            <a href="<%= request.getContextPath()%>/editProperty?id=<%= p.getPropertyId()%>">Edit</a>
            <a href="<%= request.getContextPath()%>/DeletePropertyServlet?id=<%= p.getPropertyId()%>">Delete</a>
        </div>
        <hr/>
        <% }%>
    </body>
</html>
