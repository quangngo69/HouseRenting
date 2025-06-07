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
        <a href="<%= request.getContextPath()%>/views/dashboard.jsp" class="btn">Back to Dashboard</a>
        <div class="property-grid">
            <%
                List<Property> pending = (List<Property>) request.getAttribute("pendingProperties");
                if (pending != null && !pending.isEmpty()) {
                    for (Property p : pending) {
            %>
            <div class="property-card">
                <h3><%= p.getTitle()%></h3>
                <p><strong>Area:</strong> <%= p.getArea()%></p>
                <p><strong>Type:</strong> <%= p.getPropertyType()%></p>
                <p><strong>Price:</strong> $<%= p.getPrice()%></p>

                <a href="${pageContext.request.contextPath}/propertyDetails?id=<%= p.getPropertyId()%>" class="btn3">View Details</a>

                <form method="post" action="approveProperty" style="display:inline;">
                    <input type="hidden" name="propertyId" value="<%= p.getPropertyId()%>"/>
                    <input type="submit" value="Approve" class="btn3"/>
                </form>

                <form method="post" action="rejectProperty" style="display:inline;">
                    <input type="hidden" name="propertyId" value="<%= p.getPropertyId()%>"/>
                    <input type="submit" value="Reject" class="btn3"/>
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
        </div>


    </body>
</html>
