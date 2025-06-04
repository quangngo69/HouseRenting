<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
<head><title>Add Funds</title></head>
<body>
    <h2>Add Funds to Your Account</h2>

    <p>Current Balance: $<%= user.getBalance() %></p>

    <form action="${pageContext.request.contextPath}/addFunds" method="post">
        Amount: <input type="number" name="amount" step="0.01" min="1" required />
        <input type="submit" value="Add Funds" />
    </form>

    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
