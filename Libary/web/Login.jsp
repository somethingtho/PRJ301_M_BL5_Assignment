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
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="util.css">
    </head>
    <body>
        <%
            Boolean loginFailed = (Boolean)request.getAttribute("loginFailed");
            if (loginFailed != null && loginFailed){
        %>
        <script type="text/javascript">
            alert("The email or password is not correct.");
        </script>
        <%
    }
        %>
        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" action="login" method="post">
                        <span class="login100-form-logo">
                            <img class="logog" src="images/OIP.jpg">
                        </span>
                        <span class="login100-form-title p-b-34 p-t-27">
                            Log in
                        </span>
                        <div class="wrap-input100 validate-input" data-validate="Enter email">
                            <input class="input100" type="text" name="email" placeholder="Email">
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>
                        <div class="emt">
                        </div>
                        <div class="emt">
                        </div>
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Login
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
