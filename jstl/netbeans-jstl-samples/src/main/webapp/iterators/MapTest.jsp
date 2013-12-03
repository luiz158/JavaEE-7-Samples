<%-- 
    Document   : MapTest
    Created on : Nov 30, 2013, 12:05:36 PM
    Author     : Masudul Haque
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        

        <%@ page import="java.util.*" %>

        <h2> Server Info</h2>
        Server info = <%= application.getServerInfo()%> <br>
        Servlet engine version = <%=  application.getMajorVersion()%>.<%= application.getMinorVersion()%><br>
        Java version = <%= System.getProperty("java.vm.version")%><br>
        <%
            Map map = new LinkedHashMap();
            map.put("2", "String(2)");
            map.put(new Integer(2), "Integer(2)");
            map.put(new Long(2), "Long(2)");
            map.put(42, "AutoBoxedNumber");

            pageContext.setAttribute("myMap", map);
            Integer lifeInteger = new Integer(42);
            Long lifeLong = new Long(42);
        %>
        <h3>Looking up map in JSTL - integer vs long </h3>

        This page demonstrates how JSTL maps interact with different types used for keys in a map.
        Specifically the issue relates to autoboxing by java using map.put(1, "MyValue") and attempting to display it as ${myMap[1]}
        The map "myMap" consists of four entries with different keys: A String, an Integer, a Long and an entry put there by AutoBoxing Java 5 feature.       

        <table border="1">
            <tr><th>Key</th><th>value</th><th>Key Class</th></tr>
                    <c:forEach var="entry" items="${myMap}" varStatus="status">
                <tr>      
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                    <td>${entry.key.class}</td>
                </tr>
            </c:forEach>
        </table>

        <h4> Accessing the map</h4>    
        Evaluating: ${"${myMap['2']}"} = <c:out value="${myMap['2']}"/><br>
        Evaluating: ${"${myMap[2]}"}   = <c:out value="${myMap[2]}"/><br>    
        Evaluating: ${"${myMap[42]}"}   = <c:out value="${myMap[42]}"/><br>    

        <p>
            As you can see, the EL Expression for the literal number retrieves the value against the java.lang.Long entry in the map.
            Attempting to access the entry created by autoboxing fails because a Long is never equal to an Integer
        <p>

            lifeInteger = <%= lifeInteger%><br/>
            lifeLong = <%= lifeLong%><br/>
            lifeInteger.equals(lifeLong) : <%= lifeInteger.equals(lifeLong)%> <br>
    </body>
</html>
