<%@ page import="java.util.List, model.PropertyImages" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<PropertyImage> images = (List<PropertyImage>) request.getAttribute("images");
    if (images != null) {
        for (PropertyImage img : images) {
%>
    <div style="margin:10px;">
        <img src="<%= img.getPath() %>" width="100"/>
        <form method="post" action="DeleteImageServlet" style="display:inline;">
            <input type="hidden" name="imageId" value="<%= img.getId() %>"/>
            <input type="submit" value="Delete"/>
        </form>
    </div>
<%
        }
    }
%>
