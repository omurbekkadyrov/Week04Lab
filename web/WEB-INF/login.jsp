<%-- 
    Document   : login
    Created on : Oct 1, 2018, 8:19:11 PM
    Author     : 759388
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
        <form action="login" method="post">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login"><br>
            <input type="checkbox" name="rememberme" value="${rememberme}"${rememberme}>Remember me<br>
        </form>
        <div>
            ${invalidlogin}
        </div>
    </body>
</html>
