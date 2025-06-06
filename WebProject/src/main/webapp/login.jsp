<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
        <title>Login</title>
    </head>
    <body>
        <div class="form-container">
            
            <form method="post" action="LoginServlet" class="form-box">
                <h2 class="form-title">Login</h2>
                <label>Username:</label>
                <input type="text" name="username" required /><br/>
                
                <label>Password:</label>
                <input type="password" name="password" required /><br/>
                
                <input type="submit" value="Login" class="btn"/>
                <a href="register.jsp" class="btn">Register</a>
            </form>
        </div>
    </body>
</html>
