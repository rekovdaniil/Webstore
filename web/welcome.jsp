<%@ page import="java.util.Date" %>
<%@ page import="appLayer.GlobalVars" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 12.02.2018
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<html>

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

<body onload="startTime()">
<font color = red>
    <h1 align = right id="txt">Current Time</h1>

</font>
</body>

<head>
    <meta charset="UTF-8">
    <title>Building Store</title>
</head>

<body>
<marquee behavior="scroll" direction="left"><h1><font color="red">
    Welcome, Dear:
    <%
        out.print(GlobalVars.UserName + " in DarkNet ");
        Date Date = new Date();
        out.print(Date.getYear() + 1900 );
    %>
   </font></h1></marquee>
<div align = right><img src="img/btc.png">
<h2><font color = "#90ee90">
    <%
     Thread thread = new Thread("New Thread") {
      public void run(){
        //System.out.println("run by: " + getName());
        try{
         URL BtcUSD = new URL("https://blockchain.info/tobtc?currency=USD&value=1");
        URLConnection yc = BtcUSD.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine = in.readLine();
       // while ((inputLine = in.readLine()) != null)
            out.println("1 BTC = " + 1/Float.parseFloat(inputLine) + "USD");
        in.close();
        } catch(Exception e){}
      }
   };

       // thread.start();

   // response.setIntHeader("Refresh", 5);
   /*
         URL BtcUSD = new URL("https://blockchain.info/tobtc?currency=USD&value=1");
        URLConnection yc = BtcUSD.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            out.println("1 BTC = " + 1/Float.parseFloat(inputLine) + "USD");
        in.close();
        */
    %>
</div>
</font></h2>
<div class="grid-container">
    <section class="logo">
        <img title="logo" src="img/logo.png">
    </section>

    <section class="title">
        <div id="blink6">Great Store - Great Offers!</div>
        <img src="img/cahrt.png" align = "left" width = 80px height  =80px topmargin = 40px/>
    </section>

    </section>
    <section class="menu">
        <div class="flex-container-menu">
            <div class="flex-item-menu">

                    <table>
                        <tr>
                            <td></td>
                            <td><a><b><font color = "red">Signed as:</font></b></a></td>

                        </tr>
                        <tr>
                            <td></td>
                            <td><p><u> <font color = "yellow">
                                <%
                                out.print(GlobalVars.UserName);
                            %></font></u></p></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/index.jsp"><input type ="submit" value =" Log out " align = right/></a></td>
                        </tr>
                    </table>

            </div>

            <div class="flex-item-menu">
                <a href="/userslist.jsp"><img src="img/users.png" align = "left" width = 40px height  =40px/>List of all users</a>
            </div>
            <div class="flex-item-menu">
                <a href="/itemslist"><img src="img/items.png" align = "left" width = 40px height  =40px/>List of all items</a>
            </div>
            <div class="flex-item-menu">
                <a href="additem.jsp"><img src="img/item.png" align = "left" width = 40px height  =40px/>Add new item</a>
            </div>
            <div class="flex-item-menu">
                <a href="chart.jsp"><img src="img/cahrt.png" align = "left" width = 40px height  =40px/>View Chart</a>
            </div>


        </div>
    </section>

    <section class="main">

        <div class="flex-container-main" >
            ${itemslist}
        </div>



    </section>

</div>
</body>
</html>