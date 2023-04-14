<%-- 
    Document   : ListHold
    Created on : Feb 24, 2023, 9:19:49 AM
    Author     : phuonglh
--%>

<%@page import="dbObject.hold"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Hold</h1>
        <%
            ArrayList<hold> list = (ArrayList<hold>)request.getAttribute("listHold");
            if (list==null || list.size()==0){
                out.println("No hold in the list.");
            }
            else {
            %>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Actions</td>
                </tr>
                <%
                    for (hold cat : list){
                    %>
                    <tr>
                        <td><%= cat.getId() %></td>
                        <td><%= cat.getS_time()%></td>
                        <td><%= cat.getBook_copy_id()%></td>
                        <td><%= cat.getPatron_account_id()%></td>
                        <td>
                            <a href="Updatehold?id=<%= cat.getId() %>">Update</a>
                            <a href="Deletehold?id=<%= cat.getId() %>">Delete</a>
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
        <a href="InsertHold"><button>Add hold</button></a>
    </body>
</html>
