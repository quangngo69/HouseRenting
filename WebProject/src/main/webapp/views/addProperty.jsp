<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>Add Property</title></head>
    <body>
        <h2>Add New Property</h2>
        <form method="post" action="${pageContext.request.contextPath}/addProperty" enctype="multipart/form-data">
            Title: <input type="text" name="title" required/><br/>
            Description: <textarea name="description"></textarea><br/>
            Price: <input type="number" name="price" required/><br/>

            Area (m²): <input type="number" name="area" required/><br/>
            Bedrooms: <input type="number" name="bedroomCount" required/><br/>
            Bathrooms: <input type="number" name="bathroomCount" required/><br/>

            District: 
            <select name="district" required>
                <option value="1">District 1</option>
                <option value="3">District 3</option>
                <option value="4">District 4</option>
                <option value="5">District 5</option>
                <option value="6">District 6</option>
                <option value="7">District 7</option>
                <option value="8">District 8</option>
                <option value="10">District 10</option>
                <option value="11">District 11</option>
                <option value="12">District 12</option>
                <option value="Tan Binh">Tan Binh</option>
                <option value="Tan Phu">Tan Phu</option>
                <option value="Binh Tan">Binh Tan</option>
                <option value="Binh Thanh">Binh Thanh</option>
                <option value="Go Vap">Go Vap</option>
                <option value="Phu Nhuan">Phu Nhuan</option>
            </select><br/>

            Street: <input type="text" name="street" required/><br/>
            Town: <input type="text" name="town" required/><br/>

            Type:
            <select name="propertyType" required>
                <option value="APARTMENT">Apartment</option>
                <option value="HOUSE">House</option>
                <option value="TOWNHOUSE">Townhouse</option>
                <option value="DUPLEX">Duplex</option>
                <option value="BUNGAGLOW">Bungalow</option>
            </select><br/>

            Image: <input type="file" name="propertyImage"/><br/>

            <input type="submit" value="Add Property"/>
        </form>

        <% String msg = (String) request.getAttribute("message"); %>
        <script>
            <% if ("success".equals(msg)) { %>
                alert("Successfully added");
            <% } else if ("fail".equals(msg)) { %>
                alert("Failed to add");
            <% } %>
        </script>
    </body>
</html>
