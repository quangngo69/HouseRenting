<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
        <title>Register</title>
    </head>
    <body>
        <div class="form-container">
            
            <form method="post" action="RegisterServlet" class="form-box">
                <h2 class="form-title">Register</h2>
                <label>Full Name:</label>
                <input type="text" name="fullname" required /><br/>
                
                <label>Username:</label>
                <input type="text" name="username" required /><br/>
                
                <label>Password:</label>
                <input type="password" name="password" required /><br/>
                
                <label>User Type:</label>
                <select name="userType">
                    <option value="TENANT">Tenant</option>
                    <option value="LANDLORD">Landlord</option>
                </select><br/>
                
                <input type="submit" value="Register" class="btn"/>
                <a href="${pageContext.request.contextPath}/login.jsp" class="btn">Already have an account?</a>
            </form>
        </div>
    </body>
</html>
