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
        <title>Login page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
    </head>
    <body>
        <%
            Boolean loginFailed = (Boolean)request.getAttribute("loginFailed");
            if (loginFailed != null && loginFailed){
            out.println("The email or password is not correct.");
            }
        %>
        
        <form action="login" method="post">
            <div class="container">
                <label for="uname"><b>Email:</b></label></br>
                <input type="text" placeholder="Enter Username" name="email" required></br>

                <label for="psw"><b>Password</b></label></br>
                <input type="password" placeholder="Enter Password" name="password" required></br>

                <button type="submit">Login</button></br>
                <label>
                </label>
            </div>
        </form>
    </body>
</html>
