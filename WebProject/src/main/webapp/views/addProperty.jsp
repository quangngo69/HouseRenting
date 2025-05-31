<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add Property</title></head>
<body>
<h2>Add New Property</h2>
<form method="post" action="AddPropertyServlet" enctype="multipart/form-data">
    Title: <input type="text" name="title" required/><br/>
    Description: <textarea name="description"></textarea><br/>
    Price: <input type="number" name="price" required/><br/>
    City: <input type="text" name="city" required/><br/>
    Type: <select name="type">
        <option value="House">House</option>
        <option value="Apartment">Apartment</option>
    </select><br/>
    Image: <input type="file" name="propertyImage"/><br/>
    <input type="submit" value="Add Property"/>
</form>
</body>
</html>
