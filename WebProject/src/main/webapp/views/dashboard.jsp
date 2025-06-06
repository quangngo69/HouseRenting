<%@ page import="model.User" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
        <title>Dashboard</title>
    </head>
    <body>
        <div class="wrapper">
            <%
                User user = (User) session.getAttribute("user");
                String username = user != null ? user.getUsername() : "Guest";
                String usertype = user != null && user.getUserType() != null ? user.getUserType().name() : "Unknown";

                if ("ADMIN".equals(usertype)) {
            %>
            <jsp:include page="/views/includes/header-admin.jsp" />
            <%
            } else if ("LANDLORD".equals(usertype)) {
            %>
            <jsp:include page="/views/includes/header-landlord.jsp" />
            <%
            } else if ("TENANT".equals(usertype)) {
            %>
            <jsp:include page="/views/includes/header-tenant.jsp" />
            <%
            } else {
            %>
            <jsp:include page="/views/includes/header.jsp" /> <%-- fallback or guest header --%>
            <%
                }
            %>

<!--<h2>Welcome, <%= username%> (<%= usertype%>)</h2 //>-->

            <div class="main-content">
                <% if ("ADMIN".equals(usertype)) { %>
                <a href="${pageContext.request.contextPath}/pendingProperties" class="btn2">View Pending Properties</a>
                <% } else if ("LANDLORD".equals(usertype)) { %>
                <a href="${pageContext.request.contextPath}/views/addProperty.jsp" class="btn2">Add Property</a>
                <a href="${pageContext.request.contextPath}/myProperties" class="btn2">My Properties</a>
                <% } else if ("TENANT".equals(usertype)) { %>
                <a href="${pageContext.request.contextPath}/propertyList" class="btn2">Browse Properties</a>
                <a href="${pageContext.request.contextPath}/myRentings" class="btn2">My Renting</a>
                <a href="${pageContext.request.contextPath}/views/addFunds.jsp" class="btn2">Add Funds</a>
                <% }%>
            </div>


            <jsp:include page="/views/includes/footer.jsp" />
        </div>
    </body>
</html>

