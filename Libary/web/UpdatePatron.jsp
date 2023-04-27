<%-- 
    Document   : UpdatePatron
    Created on : Apr 26, 2023, 12:13:36 PM
    Author     : CC
--%>

<%@page import="dbObject.Patron"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="util.css">
        <title>Edit Patron</title>
    </head>
    <body>
        <%
            Patron cat = (Patron)request.getAttribute("Patron");
            if (cat==null){
                response.sendRedirect("ListPatron");
            }
        %>
        <div id="navbar">
            <img class="smalllogo" src="images/OIP.jpg">
            <a href="Logout">Log out</a>
            <a href="ListPatron">Patron</a>
            <a href="ListWait">Waiting list</a>
            <a href="ListHold">Home</a>
        </div>
        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" action="UpdatePatron?id=<%= cat.getId() %>" method="post">
                        <span class="login100-form-logo">
                            <img class="logog" src="images/OIP.jpg">
                        </span>
                        <span class="login100-form-title p-b-34 p-t-27">
                            Edit Patron <%= cat.getId() %>
                        </span>
                        <div class="wrap-input100 validate-input" data-validate="Enter Patron First Name:">
                            <span class="login100-form-head"> Enter Patron First Name: </span>
                            <input class="input100" type="text" name="fname" value="<%= cat.getFname() %>">
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter Patron Surname:">
                            <span class="login100-form-head"> Enter Patron Surname: </span>
                            <input class="input100" type="text" name="lname" value="<%= cat.getSurname() %>">
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter Patron Email:">
                            <span class="login100-form-head"> Enter Patron Email: </span>
                        <input class="input100" type="text" name="email" value="<%= cat.getEmail() %>"/>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter Patron Status: ">
                            <span class="login100-form-head"> Enter Patron Status: </span>
                        <input class="input100" type="text" name="status" value="<%= cat.getStatus() %>"/>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Update
                            </button>
                        </div>
                        <div class="emt">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
