<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<form method="post" action="RegisterServlet">
    Full Name: <input type="text" name="fullname" required /><br/>
    Username: <input type="text" name="username" required /><br/>
    Password: <input type="password" name="password" required /><br/>
    User Type:
    <select name="userType">
        <option value="TENANT">Tenant</option>
        <option value="LANDLORD">Landlord</option>
    </select><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
