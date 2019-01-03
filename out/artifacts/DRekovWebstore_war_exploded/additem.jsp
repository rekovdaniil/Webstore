<%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 14.02.2018
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <meta charset="UTF-8">
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

</head>
<a href ="/welcome.jsp" ><img src="img/back.png" align = "left" width = 180px height  =60px/> </a>
<body>

<h1 align = "center"> Add new item </h1>
<h2 style="color:red;" align = "center">${error}</h2>
<form action="/additem"  method="post" enctype="multipart/form-data">
    <table align = "center">
        <tr>
            <td>Enter title:</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>Enter type:</td>
            <td><input type="text" name="category"></td>
        </tr>
        <tr>
            <td>Enter description:</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>Enter illustration:</td>
            <td><input type="file" name="illustration"
                       multiple accept="image/gif, image/jpeg, image/png">
            </td>
        </tr>
        <tr>
            <td>Enter price:</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"/></td>
        </tr>

    </table>
</form>
</body>
</html>