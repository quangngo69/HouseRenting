<%@ page import="model.User" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css" />
        <title>Dashboard</title>
    </head>
    <body>
        <h2>Welcome, <%= username%> (<%= usertype%>)</h2>

        <% if ("ADMIN".equals(usertype)) { %>
        <a href="pendingProperties">View Pending Properties</a>
        <% } else if ("LANDLORD".equals(usertype)) { %>
        <a href="${pageContext.request.contextPath}/views/addProperty.jsp">Add Property</a><br/>
        <a href="${pageContext.request.contextPath}/myProperties">My Properties</a>
        <% } else if ("TENANT".equals(usertype)) { %>
        <a href="${pageContext.request.contextPath}/propertyList">Browse Properties</a><br/>
        <a href="${pageContext.request.contextPath}/myRentings">My Renting</a><br/>
        <a href="${pageContext.request.contextPath}/views/addFunds.jsp">Add Funds</a>
        <% }%>

        <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
    </body>
</html>

<jsp:include page="/views/includes/footer.jsp" />