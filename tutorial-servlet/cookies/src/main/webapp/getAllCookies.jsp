<%-- 
    Document   : getAllCookies
    Created on : Sep 21, 2013, 6:45:41 PM
    Author     : Masudul Haque
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Cookies are</h1>
        <%
            Cookie[] cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                String value = cookies[i].getValue();
                out.println(name);
                out.println(value);
            }
        %>
    </body>
</html>
