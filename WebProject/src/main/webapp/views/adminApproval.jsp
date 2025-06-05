<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, model.Property" %>
<html>
    <head>
        <title>Admin Approval</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
    </head>
    <body>
        <h2>Pending Property Approvals</h2>

        <%
            List<Property> pending = (List<Property>) request.getAttribute("pendingProperties");
            if (pending != null && !pending.isEmpty()) {
                for (Property p : pending) {
        %>
        <div>
            <h1><%= p.getTitle()%></h1>
            <h2><%= p.getArea()%></h2>
            <h2><%= p.getPropertyType()%></h2>
            <h2><%= p.getPrice()%></h2>
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
        <a href="<%= request.getContextPath() %>/views/dashboard.jsp">Back to Dashboard</a>

    </body>
</html>
