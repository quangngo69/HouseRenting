<%@ page session="true" %>
<%@ page import="model.Renting" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>My Renting</title></head>
    <body>
        <h2>My Renting</h2>
        <%
            List<Renting> bookings = (List<Renting>) request.getAttribute("bookings");
            for (Renting b : bookings) {
        %>
        <div style="border:1px solid #ccc; margin:10px; padding:10px;">
            Property ID: <%= b.getPropertyId() %><br/>
            Status: <%= b.getStatus() %><br/>
            Booked On: <%= b.getBookDate() %><br/>
            From: <%= b.getStartDate() %> to <%= b.getEndDate() %><br/>
        </div>
        <% } %>
    </body>
</html>
