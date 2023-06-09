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
        <link rel="stylesheet" type="text/css" href="main.css" />
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="util.css">
        <script type="text/javascript" src="//code.jquery.com/jquery-1.7.1.js"></script>        
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            ArrayList<hold> list = (ArrayList<hold>)request.getAttribute("listhold");
            if (list==null || list.size()==0){
        %>
        <script type="text/javascript">
            alert("No hold in the list.");
        </script>
        <%
            }
            else {
        %>
        <div id="navbar">
            <img class="smalllogo" src="images/OIP.jpg">
            <a href="Logout">Log out</a>
            <a href="ListPatron">Patron</a>
            <a href="ListWait">Waiting list</a>
            <a href="ListHold">Home</a>
        </div>
        <div class="limiter">
            <div class="container-table100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-table100">
                    <div class="table100">
                        <table id="table">
                            <thead>
                                <tr class="table100-head">
                                    <th>ID</th>
                                    <th>Book name</th>
                                    <th></th>
                                    <th>Patron name</th>
                                    <th>Register on</th>
                                    <th>Due on</th>
                                    <th>Status</th>
                                    <th><input class="searchbar" type="text" id="search" placeholder="Type to search"></th>
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
                                    <%
                                   System.out.println(cat.getPiclink());
                                %>
                                    <td><img class="cover" src="<%= cat.getPiclink()%>"></td>
                                    <td><%= cat.getPatron_name()%></td>
                                    <td><%= cat.getS_time()%></td>
                                    <td><%= cat.getE_time()%></td>
                                    <td>
                                        <%if(cat.getStatus().equals("Good")){%>
                                        <%=cat.getStatus()%>
                                        <%} else{%>
                                        <a href="Overdue?id=<%= cat.getId() %>" onclick="return confirm('Send a warning?');"><%=cat.getStatus()%></a>
                                        <%}%>
                                    </td>
                                    <td>
                                        <a href="CheckOut?id=<%= cat.getId() %>" onclick="return confirm('Are you sure you want to check out this item?');"><button class="login100-form-btn">Check Out</button></a>
                                        <a href="Delete?id=<%= cat.getId() %>" onclick="return confirm('Are you sure you want to delete this item?');"><button class="login100-form-btn">Delete</button></a>
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
                        <div class="container-login100-form-btn">
                            <a href="InsertHold"><button class="login100-form-btn">Add Hold</button></a>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>    
        <script type="text/javascript">//<![CDATA[


var $rows = $('#table tbody tr');
$('#search').keyup(function() {
    
var val = '^(?=.*\\b' + $.trim($(this).val()).split(/\s+/).join('\\b)(?=.*\\b') + ').*$',
reg = RegExp(val, 'i'),
text;
    
$rows.show().filter(function() {
text = $(this).text().replace(/\s+/g, ' ');
return !reg.test(text);
}).hide();
});


//]]></script>
    </body>
</html>
