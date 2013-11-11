<%-- 
    Document   : Process.jsp
    Created on : Nov 11, 2013, 4:35:15 PM
    Author     : Masud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        a1, a2, a3 can be directly accessed as: ${a1} ${a2} ${a3}<br />

        Each attribute can also be accessed as: ${requestScope.a1} ${sessionScope.a2} ${applicationScope.a3}<br />

        Accessing the repeated attribute directly then the value will be for: ${c}<br />
        Common attribute can also be accessed as: ${requestScope.c} ${sessionScope.c} ${applicationScope.c}<br />

        Trying to access out of scope attribute we get: ${applicationScope.a1}
    </body>
</html>
