<%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 14.02.2018
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <title>Users list</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

<a href ="/welcome.jsp" ><img src="img/back.png" align = "left" width = 180px height  =60px/> </a>
<br>
<style>
    body { background: url(img/Background.jpg); }
    table{
        background: rgba(255, 255, 255, 0.3);
        color: #fff;
        padding: 5px;
    }
    h1 {
        color: white;}
    h2 {
        color: white;
    }
</style>

<br>
<br>
<br>

<h1 align = "center">List of all users:</h1>
    <table align = "center" bgcolor = "#7b68ee" border="1" cellpadding="5" style="border-collapse: collapse; border: 1px solid black;">

        <tr>
            <td><p><font color = "white">ID</font></p> </td>
            <td><p><font color = "white">E-mail:</font></p> </td>
            <td><p><font color = "white">Password</font></p> </td>
            <td><p><font color = "white">Name</font></p> </td>
            <td><p><font color = "white">Surname</font></p> </td>
            <td><p><font color = "white"><img src="img/cross.png"> </font></p> </td>
        </tr>
        ${UsersList}
        <tr>
            <td><form action="/userslist" method="get">
                <input type="submit" name="Get_Users" value ="Refresh" width="10" align = "center"/>
            </form></td>

        </tr>
    </table>

<h2 style="color:red;" align = "center">${error}</h2>

</font></p> </td>

</body>
</html>
