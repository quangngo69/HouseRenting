<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
<head><title>Payment Successful</title></head>
<body>
    <h2>Payment Successful!</h2>
    <p>Thank you for your booking/payment.</p>
    <p>Your updated balance: $<%= user.getBalance() %></p>
    <a href="views/dashboard.jsp">Go to Dashboard</a>
</body>
</html>
