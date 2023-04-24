<%-- 
    Document   : ListHold
    Created on : Feb 24, 2023, 9:19:49 AM
    Author     : CC
--%>

<%@page import="dbObject.hold"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css" />
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="util.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            ArrayList<hold> list = (ArrayList<hold>)request.getAttribute("listhold");
            if (list==null || list.size()==0){
                out.println("No hold in the list.");
            }
            else {
        %>
        <div id="navbar">
            
            <a href="#home">Home</a>
            <a href="#news">News</a>
            <a href="#contact">Contact</a>
        </div>
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th>ID</th>
                                    <th>Book name</th>
                                    <th>Patron name</th>
                                    <th>Register on</th>
                                    <th>Due on</th>
                                    <th>Status</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (hold cat : list){
                                %>
                                <tr>
                                    <td><%= cat.getId() %></td>
                                    <td><%= cat.getBook_name()%></td>
                                    <td><%= cat.getPatron_name()%></td>
                                    <td><%= cat.getS_time()%></td>
                                    <td><%= cat.getE_time()%></td>
                                    <td><%= cat.getStatus()%></td>
                                    <td>
                                        <a href="CheckOut?id=<%= cat.getId() %>" onclick="return confirm('Are you sure you want to check out this item?');">Check out</a>
                                    </td>
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
                        <!--                        <div class="container-login100-form-btn">
                                                    <a href="InsertHold.jsp"><button class="login100-form-btn">Add hold</button></a>
                                                </div>
                                                <div class="container-login100-form-btn">
                                                    <a href="ListWait"><button class="login100-form-btn">Waiting</button></a>
                                                </div>-->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
