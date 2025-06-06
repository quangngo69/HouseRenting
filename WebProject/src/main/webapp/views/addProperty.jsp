<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style2.css" />
    <title>Add Property</title>
</head>
<body>
    <h2 class="form-title">Add New Property</h2>
    <a href="${pageContext.request.contextPath}/views/dashboard.jsp" class="btn3">Back to Dashboard</a>
    <form method="post" action="${pageContext.request.contextPath}/addProperty" enctype="multipart/form-data" class="property-form">
        <table>
            <tr><td>Title:</td><td><input type="text" name="title" required class="input-field"/></td></tr>
            <tr><td>Description:</td><td><textarea name="description" class="input-field"></textarea></td></tr>
            <tr><td>Price:</td><td><input type="number" name="price" required class="input-field"/></td></tr>
            <tr><td>Area (m²):</td><td><input type="number" name="area" required class="input-field"/></td></tr>
            <tr><td>Bedrooms:</td><td><input type="number" name="bedroomCount" required class="input-field"/></td></tr>
            <tr><td>Bathrooms:</td><td><input type="number" name="bathroomCount" required class="input-field"/></td></tr>
            <tr><td>District:</td>
                <td>
                    <select name="district" required class="input-field">
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
                    </select>
                </td>
            </tr>
            <tr><td>Street:</td><td><input type="text" name="street" required class="input-field"/></td></tr>
            <tr><td>Town:</td><td><input type="text" name="town" required class="input-field"/></td></tr>
            <tr><td>Type:</td>
                <td>
                    <select name="propertyType" required class="input-field">
                        <option value="APARTMENT">Apartment</option>
                        <option value="HOUSE">House</option>
                        <option value="TOWNHOUSE">Townhouse</option>
                        <option value="DUPLEX">Duplex</option>
                        <option value="BUNGAGLOW">Bungalow</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Image:</label></td>
                <td><input type="file" name="propertyImage" accept="image/*" required class="input-field"/></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="Add Property" class="btn3"/>
    </form>

    <br/>

    <% String msg = (String) request.getAttribute("message"); %>
    <script>
        <% if ("success".equals(msg)) { %>
        alert("Successfully added");
        <% } else if ("fail".equals(msg)) { %>
        alert("Failed to add");
        <% }%>
    </script>
</body>
</html>
