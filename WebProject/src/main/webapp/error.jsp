<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Error</title></head>
<body>
<h2>An error occurred</h2>
<p><%= request.getAttribute("errorMessage") %></p>
<a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
