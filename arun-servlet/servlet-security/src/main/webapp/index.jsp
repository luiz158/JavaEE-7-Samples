<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet Security</title>
    </head>
    <body>
        <h1>Servlet Security</h1>
        
        <p>Make sure to invoke "./bin/asadmin create-file-user --groups g1 u1" and use the password "p1" when prompted.
        Then call the <a href="${pageContext.request.contextPath}/SecureServlet">GET</a> method.<br/>
    </body>
</html>
