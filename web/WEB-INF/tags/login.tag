<%-- 
    Document   : login
    Created on : 11-Oct-2018, 1:28:19 PM
    Author     : 763198
--%>

<%@tag description="simple login form" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%--<%@attribute name="message"%>--%>

<%-- any content can be specified here e.g.: --%>
<form name="login" method="post" action="login">
    <table>
        <tr>
            <td>Username: </td>
            <td><input type="text" name="username" autocomplete="off" autofocus="true" value="${username}"></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><input type="password" name="password" autocomplete="off"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"></td>
        </tr>
        <tr>
            <td colspan="2"><label><input type="checkbox" name="remember"> Remember me</label></td>
        </tr>
    </table>

</form>