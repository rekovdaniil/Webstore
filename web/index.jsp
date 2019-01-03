<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.net.URL" %><%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 12.02.2018
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <meta charset="UTF-8">
  <title>Building Store</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<script>
    function startTime() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        document.getElementById('txt').innerHTML =
            h + ":" + m + ":" + s + " UTC +3";
        var t = setTimeout(startTime, 500);
    }
    function checkTime(i) {
        if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
        return i;
    }
</script>

</head>

<body onload="startTime()">
<font color = red>
  <h1 align = right id="txt">Current Time</h1>

</font>
</body>
<body>
<marquee behavior="scroll" direction="left"><h1><font color="red">
    Wellcome to Building Store! Best gear of the DarkNET

  <%
    Date Date = new Date();
    out.print(Date.getYear() + 1900);
    // response.setIntHeader("Refresh", 1);
  %>! BTC ONLY!

Please LOGIN!</font></h1></marquee>


<marquee behavior="slide" direction="right"> <img src="img/btc.png">
  <h2><font color = "#90ee90">
   <%
     URL BtcUSD = new URL("https://blockchain.info/tobtc?currency=USD&value=1");
  URLConnection yc = BtcUSD.openConnection();
  BufferedReader in = new BufferedReader(new InputStreamReader(
          yc.getInputStream()));
  String inputLine;
  while ((inputLine = in.readLine()) != null)
    out.println("1 BTC = " + 1/Float.parseFloat(inputLine) + "USD");
  in.close();
%>
  </font></h2>
</marquee>
<div class="grid-container">
  <section class="logo">
    <img title="logo" src="img/logo.png">
  </section>




  <section class="title">
    <div id="blink6">Great Store - Great Offers!</div>
    <img src="img/cahrt.png" align = "left" width = 80px height  =80px topmargin = 40px />
  </section>

  <section class="menu">
    <div class="flex-container-menu">
      <div class="flex-item-menu">
        <form action ="/login" method="post">
          <table>
            <tr>
              <td><a><b>E-mail:</b></a></td>
              <td><input type = "text" name ="loginname" width = "400"/></td>
            </tr>
            <tr>
              <td><a><b>Pass:</b></a></td>
              <td><input type ="password" name ="password" width = "10"/></td>
            </tr>
            <tr>
              <td></td>
              <td><input type ="submit" value =" Login " align = right/></td>
            </tr>
            </table>
        </form>
      </div>
      <div class="flex-item-menu">
          <a href="/login.jsp"><img src="img/items.png" align = "left" width = 40px height  =40px/>List of all items</a>
      </div>
      <div class="flex-item-menu">
          <a href="/login.jsp"><img src="img/search.png" align = "left" width = 40px height  =40px/>Search items by Type</a>
      </div>
      <div class="flex-item-menu">
          <a href="/login.jsp"><img src="img/item.png" align = "left" width = 40px height  =40px/>Add new item</a>
      </div>
      <div class="flex-item-menu">
        <a href="/register.jsp"><img src="img/users.png" align = "left" width = 40px height  =40px/>Register</a>
      </div>
    </div>
  </section>

  <section class="main">

    <div class="flex-container-main">
       <div class="flex-item">
        <img src="img/dozer.png" width="300" height="200">
        <h1>"Super Dozer X25"</h1>
        <h2>"Veichles", "300 BTC"</h2>
        <h1 id="blink">Hot deal!!!</h1>

      </div>
      <div class="flex-item">
        <img src="img/bricks.png" width="300" height="200">
        <h1>"100 red bricks"</h1>
        <h2>"Materials", "0.2 BTC"</h2>
        <h1 id="blink">Hot deal!!!</h1>
      </div>
      <div class="flex-item">
        <img src="img/crane.png" width="300" height="200">
        <h1>"30 meters Catapilet Crane"</h1>
        <h2>"Veichles", "500 BTC"</h2>
        <h1 id="blink">Hot deal!!!</h1>
      </div>
      </div>
  </section>

  <section class="footer">
    <p><font color="white">Daniel Rekov  (C) 2018</font></p>
  </section>
</div>
</body>
</html>

