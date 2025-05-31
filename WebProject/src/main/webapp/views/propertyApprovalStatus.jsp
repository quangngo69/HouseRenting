<%@ page import="java.util.List, model.Property" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Property> properties = (List<Property>) request.getAttribute("properties");
%>
<html>
<head><title>Property Approval Status</title></head>
<body>
<h2>Your Property Approval Status</h2>
<%
    for (Property p : properties) {
%>
    <div>
        <strong><%= p.getTitle() %></strong><br/>
        Status: <%= p.getStatus() %><br/>
        <hr/>
    </div>
<%
    }
%>
<a href="landlordDashboard.jsp">Back to Dashboard</a>
</body>
</html>
