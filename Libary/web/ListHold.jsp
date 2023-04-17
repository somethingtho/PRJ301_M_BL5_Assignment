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
        <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Hold</h1>
        <%
            ArrayList<hold> list = (ArrayList<hold>)request.getAttribute("listhold");
            if (list==null || list.size()==0){
                out.println("No hold in the list.");
            }
            else {
            %>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Book name</td>
                    <td>Patron name</td>
                    <td>Register on</td>
                    <td>Due on</td>
                    <td>Status</td>
                </tr>
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
                            <a href="CheckOut?id=<%= cat.getId() %>">Check out</a>
                        </td>
                    </tr>
                    <%
                    }
                %>
            </table>
            <br/>
            <%
            }
        %>
        <a href="InsertHold.jsp"><button>Add hold</button></a>
    </body>
</html>
