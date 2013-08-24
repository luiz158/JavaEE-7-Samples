<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebSocket Binary Messages</title>
    </head>
    <body>
        <h1>WebSocket Binary Messages</h1>

        <div style="text-align: center;">
            <form action=""> 
                <h2>Binary Data</h2>
                <input onclick="echoBinary()" value="Echo" type="button"> 
                <input id="myField" value="12345678" type="text"><br>
            </form>
        </div>
        <div id="output"></div>
        <script language="javascript" type="text/javascript" src="websocket.js">
        </script>
    </body>
</html>
