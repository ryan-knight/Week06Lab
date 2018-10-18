<%-- 
    Document   : home
    Created on : 27-Sep-2018, 12:24:39 PM
    Author     : 763198
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
        <div>${message}</div>
        <tags:login></tags:login>
    </body>
</html>
