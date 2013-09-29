<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concurrency Utilities for Java EE</title>
    </head>
    <body>
        <h1>Concurrency Utilities for Java EE - ManagedExecutor</h1>
        
        Get ManagedExecutor using <a href="${pageContext.request.contextPath}/TestResourceServlet">(@Resource)</a> (in Servlet)<br/>
        Get ManagedExecutor using <a href="${pageContext.request.contextPath}/TestJNDIServlet">(JNDI Context)</a> (in Servlet)<br/>
        Run <a href="${pageContext.request.contextPath}/TestEJBServlet">managed threads in EJB</a><br/>
        Submit tasks using <a href="${pageContext.request.contextPath}/TestInvokeAllServlet">invokeAll</a><br/>
        Submit tasks using <a href="${pageContext.request.contextPath}/TestInvokeAnyServlet">invokeAny</a><br/>
        Submit tasks <a href="${pageContext.request.contextPath}/TestListenerServlet">with ManagedTaskListener</a><br/>
        Run task <a href="${pageContext.request.contextPath}/TestTransactionServlet">with a UserTransaction</a><br/>
    </body>
</html>
