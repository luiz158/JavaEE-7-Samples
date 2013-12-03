<%-- 
    Document   : ternary
    Created on : Nov 30, 2013, 11:58:34 AM
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
        <h1>Ternary Operator</h1>
        <div>
            <c:set value="34" var="num"/>
            <c:out value="${num % 2 == 0 ? 'even': 'odd'}"/>
        </div>
    </body>
</html>
