<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int propertyId = Integer.parseInt(request.getParameter("id"));
%>
<html>
<head><title>Upload Image</title></head>
<body>
<h2>Upload Image for Property</h2>
<form method="post" action="UploadImageServlet" enctype="multipart/form-data">
    <input type="hidden" name="propertyId" value="<%= propertyId %>"/>
    Image: <input type="file" name="imageFile" required/><br/>
    <input type="submit" value="Upload"/>
</form>

<h3>Existing Images</h3>
<jsp:include page="propertyImages.jsp">
    <jsp:param name="propertyId" value="<%= propertyId %>"/>
</jsp:include>
</body>
</html>
