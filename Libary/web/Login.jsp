<%-- 
    Document   : Login
    Created on : Mar 1, 2023, 12:13:35 PM
    Author     : CC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            Boolean loginFailed = (Boolean)request.getAttribute("loginFailed");
            if (loginFailed != null && loginFailed){
            out.println("The email or password is not correct.");
            }
        %>
        <form action="login" method="post">
            Email: <input type="text" name="email"/><br/>
            Password: <input type="text" name="password"/><br/>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
