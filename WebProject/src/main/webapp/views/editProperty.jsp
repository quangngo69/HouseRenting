<%@ page session="true" %>
<%@ page import="model.Property" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Property property = (Property) request.getAttribute("property");
%>
<html>
    <head><title>Edit Property</title></head>
    <body>
        <h2>Edit Property</h2>
        <form method="post" action="editProperty">
            <input type="hidden" name="id" value="<%= property.getPropertyId() %>"/>

            Title: <input type="text" name="title" value="<%= property.getTitle() %>" required/><br/>
            Description: <textarea name="description"><%= property.getDescription() %></textarea><br/>
            Price: <input type="number" name="price" value="<%= property.getPrice() %>" required/><br/>
            Area (m²): <input type="number" name="area" value="<%= property.getArea() %>" required/><br/>
            Bedrooms: <input type="number" name="bedroomCount" value="<%= property.getBedroomCount() %>" required/><br/>
            Bathrooms: <input type="number" name="bathroomCount" value="<%= property.getBathroomCount() %>" required/><br/>

            District:
            <select name="district" required>
                <option value="1" <%= "1".equals(property.getDistrict()) ? "selected" : "" %>>District 1</option>
                <option value="3" <%= "3".equals(property.getDistrict()) ? "selected" : "" %>>District 3</option>
                <option value="4" <%= "4".equals(property.getDistrict()) ? "selected" : "" %>>District 4</option>
                <option value="5" <%= "5".equals(property.getDistrict()) ? "selected" : "" %>>District 5</option>
                <option value="6" <%= "6".equals(property.getDistrict()) ? "selected" : "" %>>District 6</option>
                <option value="7" <%= "7".equals(property.getDistrict()) ? "selected" : "" %>>District 7</option>
                <option value="8" <%= "8".equals(property.getDistrict()) ? "selected" : "" %>>District 8</option>
                <option value="10" <%= "10".equals(property.getDistrict()) ? "selected" : "" %>>District 10</option>
                <option value="11" <%= "11".equals(property.getDistrict()) ? "selected" : "" %>>District 11</option>
                <option value="12" <%= "12".equals(property.getDistrict()) ? "selected" : "" %>>District 12</option>
                <option value="Tan Binh" <%= "Tan Binh".equals(property.getDistrict()) ? "selected" : "" %>>Tan Binh</option>
                <option value="Tan Phu" <%= "Tan Phu".equals(property.getDistrict()) ? "selected" : "" %>>Tan Phu</option>
                <option value="Binh Tan" <%= "Binh Tan".equals(property.getDistrict()) ? "selected" : "" %>>Binh Tan</option>
                <option value="Binh Thanh" <%= "Binh Thanh".equals(property.getDistrict()) ? "selected" : "" %>>Binh Thanh</option>
                <option value="Go Vap" <%= "Go Vap".equals(property.getDistrict()) ? "selected" : "" %>>Go Vap</option>
                <option value="Phu Nhuan" <%= "Phu Nhuan".equals(property.getDistrict()) ? "selected" : "" %>>Phu Nhuan</option>
            </select><br/>

            Street: <input type="text" name="street" value="<%= property.getStreet() %>" required/><br/>
            Town: <input type="text" name="town" value="<%= property.getTown() %>" required/><br/>

            Type:
            <select name="type">
                <option value="APARTMENT" <%= "APARTMENT".equals(property.getPropertyType()) ? "selected" : "" %>>Apartment</option>
                <option value="HOUSE" <%= "HOUSE".equals(property.getPropertyType()) ? "selected" : "" %>>House</option>
                <option value="TOWNHOUSE" <%= "TOWNHOUSE".equals(property.getPropertyType()) ? "selected" : "" %>>Townhouse</option>
                <option value="DUPLEX" <%= "DUPLEX".equals(property.getPropertyType()) ? "selected" : "" %>>Duplex</option>
                <option value="BUNGAGLOW" <%= "BUNGAGLOW".equals(property.getPropertyType()) ? "selected" : "" %>>Bungalow</option>
            </select><br/>

            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
