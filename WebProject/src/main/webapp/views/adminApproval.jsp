<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, model.Property" %>
<html>
    <head><title>Admin Approval</title></head>
    <body>
        <h2>Pending Property Approvals</h2>

        <%
            List<Property> pending = (List<Property>) request.getAttribute("pendingProperties");
            if (pending != null && !pending.isEmpty()) {
                for (Property p : pending) {
        %>
        <div>
            <h3><%= p.getTitle() %></h3>
            <a href="ApprovePropertyServlet?id=<%= p.getPropertyId() %>">Approve</a>
            <a href="RejectPropertyServlet?id=<%= p.getPropertyId() %>">Reject</a>
        </div>
        <%
                }
            } else {
        %>
        <p>No pending properties found.</p>
        <%
            }
        %>
    </body>
</html>
