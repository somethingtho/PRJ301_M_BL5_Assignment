<%-- 
    Document   : InsertCategory
    Created on : Mar 1, 2023, 11:17:39 AM
    Author     : phuonglh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Input category info</h1>
        <%
            String error = (String)request.getAttribute("error");
            if (error != null){
                out.println(error + "<br/>");
            }
        %>
        <form action="InsertCategory" method="post">
            ID: <input type="number" name="id" required/><br/>
            Category Name: <input type="text" name="name" required/><br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
