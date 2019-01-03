<%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 12.02.2018
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>


    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<br>

<div style="display: flex; justify-content: center;">
    <img src="img/logo.gif" width = 150px height  =150px/>
</div>

<br>
<h1 align = "center">Welcome, please login:</h1>

<form action="/login" method="post">

    <table align = "center">

    <tr>
        <td><p><font color = "white">E-mail:</font></p> </td>
        <td><input type="text" name="loginname" width="30"/> </td>
    </tr>
       <tr>
        <br>
        <td> <p><font color = "white">Password:</font></p></td>
        <td> <input type="password" name="password" width="10"/></td>
    </tr>
        <tr>
            <br>
            <td></td>
            <td> <input type="submit" name="Login" value ="Login" width="10"/></td>
        </tr>

    </table>

</form>

<h2 style="color:red;" align = "center">${errorMessage}</h2>

</body>
</html>
