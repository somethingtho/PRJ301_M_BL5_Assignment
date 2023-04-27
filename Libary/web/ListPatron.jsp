<%-- 
    Document   : ListPatron
    Created on : Apr 26, 2023, 12:13:07 PM
    Author     : CC
--%>

<%@page import="dbObject.Patron"%>
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
            ArrayList<Patron> list = (ArrayList<Patron>)request.getAttribute("listPatron");
            if (list==null || list.size()==0){
        %>
        <script type="text/javascript">
            alert("No Patron in the list.");
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
                                    <th>First name</th>
                                    <th>Surname</th>
                                    <th>Status</th>
                                    <th>Email</th>
                                    <th><input class="searchbar" type="text" id="search" placeholder="Type to search"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Patron cat : list){
                                %>
                                <tr>
                                    <td><%= cat.getId() %></td>
                                    <td><%= cat.getFname()%></td>
                                    <td><%= cat.getSurname()%></td>
                                    <td><%= cat.getStatus()%></td>
                                    <td><%= cat.getEmail()%></td>
                                    <td>
                                        <a href="UpdatePatron?id=<%= cat.getId() %>"><button class="login100-form-btn">Edit Patron</button></a>
                                        <a href="DeletePatron?id=<%= cat.getId() %>" onclick="return confirm('Are you sure you want to delete this item?');"><button class="login100-form-btn">Delete Patron</button></a>
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
                            <a href="InsertPatron"><button class="login100-form-btn">Add Patron</button></a>
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
