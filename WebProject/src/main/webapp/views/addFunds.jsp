<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
        <title>Add Funds</title>
    </head>
    <body>
        <h2>Add Funds to Your Account</h2>

        <p>Current Balance: $<%= user.getBalance()%></p>

        <form action="${pageContext.request.contextPath}/addFunds" method="post">
            Amount: <input type="number" name="amount" step="0.01" min="1" class="browse-input" required />
            <input type="submit" value="Add Funds" class="btn3"/>
        </form>

        <a href="dashboard.jsp" class="btn3">Back to Dashboard</a>
    </body>
</html>
