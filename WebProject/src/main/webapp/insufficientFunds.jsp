<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
<head><title>Insufficient Funds</title></head>
<body>
    <h2>Payment Failed</h2>
    <p>Sorry, you do not have enough balance to complete this transaction.</p>
    <p>Your current balance: $<%= user.getBalance() %></p>
    <a href="views/addFunds.jsp">Add Funds</a><br/>
    <a href="views/dashboard.jsp">Back to Dashboard</a>
</body>
</html>
