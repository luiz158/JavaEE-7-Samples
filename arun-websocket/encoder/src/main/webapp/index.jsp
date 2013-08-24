<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>WebSocket - Encoder and Decoder</h1>
        <div style="text-align: center;">
            <form action=""> 
                <input onclick="echoJson()" value="Echo JSON" type="button"> 
                <input id="dataField" name="name" value="{}" type="text"><br>
            </form>
        </div>
        <div id="output"></div>
        
        <script language="javascript" type="text/javascript" src="websocket.js">
            
        </script>
    </body>
</html>
