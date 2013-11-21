<%-- 
    Document   : link
    Created on : Nov 14, 2013, 11:11:15 AM
    Author     : Masud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function confirmRemoveQuestion(link) {
                if (show_confirm()) {
                    window.location = link;
                    this.hide();
                }
                else {
                    this.hide();
                }
            }
            function show_confirm()
            {
                return confirm("Are you sure you want to do this?");
            }
        </script>
    </head>
    <body>
        <a href="#"  onclick="confirmRemoveQuestion('link')">
            Remove Link   
        </a>
        <label id="lblscore" value="100">100</label>
    </body>
</html>
