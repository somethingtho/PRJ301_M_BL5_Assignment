<%-- 
    Document   : InsertHold
    Created on : Mar 1, 2023, 11:17:39 AM
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
            String error = (String)request.getAttribute("error");
            if (error != null){
                out.println(error + "<br/>");
            }
        %>
        <form action="InsertHold" method="post">
            Book name: <input type="text" name="name" required/><br/>
            Patron id: <input type="text" name="id" required/><br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
