<%@ page import="model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
    <head><title>My Profile</title></head>
    <body>
        <h2>User Profile</h2>
        Full Name: <%= user.getFullname() %><br/>
        Username: <%= user.getUsername() %><br/>
        User Type: <%= user.getUserType() %><br/>
        Email: <%= user.getEmail() %><br/>
        <a href="changePassword.jsp">Change Password</a>
    </body>
</html>
