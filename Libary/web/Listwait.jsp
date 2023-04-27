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
        <script type="text/javascript" src="//code.jquery.com/jquery-1.7.1.js"></script>   
        <title>Waiting List</title>
    </head>
    <body>
        <div id="navbar">
            <img class="smalllogo" src="images/OIP.jpg">
            <a href="Logout">Log out</a>
            <a href="ListPatron">Patron</a>
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
                        <table id="table">
                            <thead>
                                <tr class="table100-head">
                                    <th>Book name</th>
                                    <th>Patron name</th>
                                    <th><input class="searchbar" type="text" id="search" placeholder="Type to search"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (wait cat : list){
                                %>
                                <tr>
                                    <td><%= cat.getB_name()%></td>
                                    <td><img class="cover" src="<%= cat.getPiclink()%>"></td>
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

