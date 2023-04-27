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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="util.css">
        <title>Insert Hold</title>
    </head>
    <body>
        <%
            String error = (String)request.getAttribute("error");
            if (error != null){
            %>
        <script type="text/javascript">
            alert(<%=error%> + "<br/>");
        </script>
        <%
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
                    <form class="login100-form validate-form" action="InsertPatron" method="post">
                        <span class="login100-form-logo">
                            <img class="logog" src="images/OIP.jpg">
                        </span>
                        <span class="login100-form-title p-b-34 p-t-27">
                            Insert Patron
                        </span>

                        <div class="wrap-input100 validate-input" data-validate="Enter Patron first name:">
                            <input class="input100" type="text" name="fname" placeholder="Patron first name">
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter Patron last name:">
                            <input class="input100" type="text" name="lname" placeholder="Patron last name">
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter Patron email:">
                            <input class="input100" type="text" name="email" placeholder="Patron email">
                        </div>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Add
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
