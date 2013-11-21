<%-- 
    Document   : ajax
    Created on : Nov 14, 2013, 1:07:01 PM
    Author     : Masud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#login').click(function() {
                    $('#display').html('Logging in...');
                    var username = $('#username').val();
                    var password = $('#password').val();
                    $.ajax({
                        url: 'MyServlet',
                        type: 'POST',
                        dataType: 'text',
                        data: {username: username, password: password},
                        success: function(data) {
                            $('#display').html('');
                            if (data != "SUCCESS") {
                                //TODO create an element to display validity
                                $('#display').html('Invalid Username/Password combination');
                            } else if (data == "SUCCESS") {
                                $('#username').val('');
                                $('#password').val('');
                                $('#display').html('Success!');
                            }
                            else {
                                $('#display').html('Something has gone horribly wrong.');
                            }

                        }
                    });
                    return false;
                });
            });
        </script>
    </head>
    <body>
        Username:  <input type="text" id="username"/><br/>
       Password: <input type="text" id="password"/><br/>
       <input type="button" id="login"/>
       <p id="display">
           
       </p>
    </body>
</html>
