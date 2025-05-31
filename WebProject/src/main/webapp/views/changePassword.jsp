<%@ page session="true" %>
<html>
<head><title>Change Password</title></head>
<body>
<h2>Change Your Password</h2>
<form method="post" action="ChangePasswordServlet">
    Current Password: <input type="password" name="currentPassword" required/><br/>
    New Password: <input type="password" name="newPassword" required/><br/>
    Confirm Password: <input type="password" name="confirmPassword" required/><br/>
    <input type="submit" value="Change Password"/>
</form>
</body>
</html>
