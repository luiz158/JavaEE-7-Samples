<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaMail Definition</title>
    </head>
    <body>
        <h1>JavaMail Definition</h1>
        Make sure "<%= System.getProperty("user.home") %><%= System.getProperty("file.separator") %>.javamail" contains the following name/value pairs:<p/><p/>
        <ul>
            <li>username</li>
            <li>password</li>
            <li>to</li>
        </ul>
        Send an email from "username" to "to" using <a href="${pageContext.request.contextPath}/TestServlet"/>programmatic session</a> or <a href="${pageContext.request.contextPath}/TestServlet2"/>declarative session</a>.
    </body>
</html>
