<%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 13.02.2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

<br>
<div style="display: flex; justify-content: center;">
    <img src="img/logo.gif" width = 150px height  =150px/>
</div>


<br>
<table align = "center">
    <tr>
 <h1 align = "center">Welcome, please register:</h1>
    </tr>
</table>


<form action="/register" method="post">

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
            <td> <p><font color = "white">Re-enter Password:</font></p></td>
            <td> <input type="password" name="Re-password" width="10"/></td>
        </tr>
        <tr>
            <br>
            <td> <p><font color = "white">Name</font></p></td>
            <td> <input type="text" name="Name" width="10"/></td>
        </tr>
        <tr>
            <br>
            <td> <p><font color = "white">Surname</font></p></td>
            <td> <input type="text" name="Surname" width="10"/></td>
        </tr>

        <tr>
            <br>
            <td></td>
            <td> <input type="submit" name="Register" value =" Register " width="10"/></td>
        </tr>
    </table>
</form>
<h2 style="color:red;" align = "center">${errorMessage}</h2>
</body>
</html>
