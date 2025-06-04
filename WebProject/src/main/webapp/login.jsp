<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>
<html>
    <head><title>Login</title></head>
    <body>
        <h2>Login</h2>
        <form method="post" action="LoginServlet">
            Username: <input type="text" name="username" required /><br/>
            Password: <input type="password" name="password" required /><br/>
            <input type="submit" value="Login"/>
        </form>
        <a href="register.jsp">Register</a>
    </body>
</html>
