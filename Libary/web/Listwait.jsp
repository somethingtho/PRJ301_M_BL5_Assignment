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
        <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
    </head>
    <body>
        <%
            ArrayList<wait> list = (ArrayList<wait>)request.getAttribute("listwait");
            if (list==null || list.size()==0){
                out.println("No wait in the list.");
            }
            else {
            %>
            <table border="1">
                <tr>
                    <td>Book name</td>
                    <td>Patron name</td>
                </tr>
                <%
                    for (wait cat : list){
                    %>
                    <tr>
                        <td><%= cat.getB_name()%></td>
                        <td><%= cat.getP_name()%></td>
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
    </body>
</html>

