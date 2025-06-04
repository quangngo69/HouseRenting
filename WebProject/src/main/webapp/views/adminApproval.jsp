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
            <h3><%= p.getTitle()%></h3>
            <form method="post" action="approveProperty" style="display:inline;">
                <input type="hidden" name="propertyId" value="<%= p.getPropertyId()%>"/>
                <input type="submit" value="Approve"/>
            </form>

            <form method="post" action="rejectProperty" style="display:inline;">
                <input type="hidden" name="propertyId" value="<%= p.getPropertyId()%>"/>
                <input type="submit" value="Reject"/>
            </form>

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
