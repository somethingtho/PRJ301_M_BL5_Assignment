<%-- 
    Document   : Listwait
    Created on : Apr 19, 2023, 9:29:41 AM
    Author     : CC
--%>

<%@page import="dbObject.wait"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css" />
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="util.css">
        <title>Waiting List</title>
    </head>
    <body>
        <div id="navbar">
            <img class="smalllogo" src="images/OIP.jpg">
            <a href="Logout">Log out</a>
            <a href="ListWait">Waiting list</a>
            <a href="ListHold">Home</a>
        </div>
        <%
            ArrayList<wait> list = (ArrayList<wait>)request.getAttribute("listwait");
            if (list==null || list.size()==0){
        %>
        <script type="text/javascript">
            alert("No wait in the list.");
        </script>
        <%
            }
            else {
        %>
        
        <div class="limiter">
            <div class="container-table100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th>Book name</th>
                                    <th>Patron name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (wait cat : list){
                                %>
                                <tr>
                                    <td><%= cat.getB_name()%></td>
                                    <td><%= cat.getP_name()%></td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                        <br/>
                        <%
                                }
                        %>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

