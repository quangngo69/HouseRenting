<%@ page import="java.util.List, model.Booking" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<html>
<head><title>Tenant Dashboard</title></head>
<body>
<h2>Your Booked Properties</h2>
<%
    for (Booking b : bookings) {
%>
    <div>
        <strong>Property:</strong> <%= b.getPropertyTitle() %><br/>
        <strong>Status:</strong> <%= b.getStatus() %><br/>
        <strong>Date:</strong> <%= b.getBookingDate() %><br/>
        <hr/>
    </div>
<%
    }
%>
<a href="propertyList.jsp">Browse More Properties</a>
</body>
</html>
