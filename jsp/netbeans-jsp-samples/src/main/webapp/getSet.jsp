<%-- 
    Document   : getSet
    Created on : Sep 5, 2013, 4:38:21 PM
    Author     : Masud
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
        <h1>Hello World!</h1>
        <c:set var="isAp" value="true"/>
        <c:if test="${isAp}">
            <c:out value="This is executed"/> <br/>
        <c:set var="isAp" value="false"/>    
        </c:if>
        <c:out value="${isAp}"/>
    </body>
</html>
