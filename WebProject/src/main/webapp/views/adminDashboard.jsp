<%@ page import="java.util.List, model.Property" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Property> pending = (List<Property>) request.getAttribute("pendingProperties");
%>
<html>
<head><title>Admin Dashboard</title></head>
<body>
<h2>Pending Properties for Approval</h2>
<%
    for (Property p : pending) {
%>
    <div>
        <strong><%= p.getTitle() %></strong> - by <%= p.getOwnerUsername() %><br/>
        <a href="ApprovePropertyServlet?id=<%= p.getId() %>">Approve</a> |
        <a href="RejectPropertyServlet?id=<%= p.getId() %>">Reject</a>
        <hr/>
    </div>
<%
    }
%>
</body>
</html>
