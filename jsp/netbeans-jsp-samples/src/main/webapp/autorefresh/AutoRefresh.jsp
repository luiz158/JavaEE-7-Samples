<%-- 
    Document   : AutoRefresh
    Created on : May 18, 2013, 1:09:47 PM
    Author     : Masudul Haque
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h2>Auto Refresh Header Example</h2>
        <%
            // Set refresh, autoload time as 5 seconds
            response.setIntHeader("Refresh", 5);
           
            // Get current time
            Calendar calendar = new GregorianCalendar();
            String am_pm;
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            if (calendar.get(Calendar.AM_PM) == 0) {
                am_pm = "AM";
            } else {
                am_pm = "PM";
            }
            String CT = hour + ":" + minute + ":" + second + " " + am_pm;
            out.println("Crrent Time: " + CT + "\n");
        %>
    </center>
</body>
</html>
