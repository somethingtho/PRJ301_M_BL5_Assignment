<%-- 
    Document   : CheckOut
    Created on : Apr 15, 2023, 4:28:58 PM
    Author     : CC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Hold cat = (hold)request.getAttribute("hold");
            if (cat==null){
                response.sendRedirect("ListHold");
            }
        %>
        
    </body>
</html>
