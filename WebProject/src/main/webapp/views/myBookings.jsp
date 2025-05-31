<%@ page session="true" %>
<%@ page import="model.Booking" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>My Bookings</title></head>
<body>
<h2>My Bookings</h2>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
    for (Booking b : bookings) {
%>
    <div>
        Property: <%= b.getPropertyTitle() %> <br/>
        Status: <%= b.getStatus() %><br/>
    </div>
<% } %>
</body>
</html>
