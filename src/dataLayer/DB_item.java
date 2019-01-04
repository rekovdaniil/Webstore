
package dataLayer;
import appLayer.GlobalVars;
import utils.BlobConverter;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
/**
 * Created by Daniil on 14.02.2018.
 */

public class DB_item {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/buildingstore";
    static final String USER = "webappuser";
    static final String PASS = "enuter74";

    //String DB_Url = System.getProperty("JDBC_CONNECTION_STRING");
    //String DB_User = System.getProperty("JDBC_USER");
    //String DB_Password = System.getProperty("JDBC_PASSWORD");
    //String DB_Connection_String = DB_Url + "?user=" + DB_User + "&password=" + DB_Password;




    public boolean RegisterNewItem(String title, String category, String description, String illustration, String price, Part filepart) {
        boolean Registred = false;
        //Запрос на добавление айтема

        try {
            Class.forName(JDBC_DRIVER);

            //Connection conn = DriverManager.getConnection(DB_Connection_String);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            System.out.println(title);
            System.out.println(category);
            System.out.println(description);
            System.out.println(illustration);
            System.out.println(price);



            String sql = "INSERT INTO items (id, title,  category, description, illustration, price) VALUES (NULL , ?, ?, ?, ?, ?)";
            System.out.println(sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, category);
            stmt.setString(3, description);
            //File image = new File("c:\\add.jpg");
            //FileInputStream fis = new FileInputStream(image);
            //stmt.setBinaryStream(4, fis, (int) image.length());
            InputStream inputStream = filepart.getInputStream();
            stmt.setBinaryStream(4, inputStream);
            stmt.setInt(5, Integer.parseInt(price));
            stmt.executeUpdate();
            System.out.println(stmt);

            Registred = true;
            conn.commit();
           // fis.close();
            stmt.close();
            conn.close();


            return Registred;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Registred;
    }


    public boolean GetAllItems() {
        boolean GOT = false;
        GlobalVars.ItemsListAnswer = "";
        //Запрос на добавление айтема
        try {
            Class.forName(JDBC_DRIVER);

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
           // Connection conn = DriverManager.getConnection(DB_Connection_String);

            //Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            String sql = "SELECT id, title,  category, description, illustration, price FROM items ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                String category = resultSet.getString(3);
                String description = resultSet.getString(4);
                Blob illustration = resultSet.getBlob(5);
                Integer price = resultSet.getInt(6);


                BlobConverter Blobconverter = new BlobConverter();
                String ImageGot =  Blobconverter.readImageFromDb(illustration);

                GlobalVars.ItemsListAnswer = GlobalVars.ItemsListAnswer + "<div class=\"flex-item\"><img alt=\"\" src=\"data:image/jpg;base64," + ImageGot + "\" width=\"300\" height=\"200\"><h1>"+title+"</h1><h2>"+category+"</h2><h2>"+description+"</h2><h2>Price: "+price+" BTC</h2><img src=\"img/btc_small.png\" width = 25px height  =25px/><form action=\"/buy\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""+id+"\"/>\n<input type=\"submit\" name=\"BuyButton\" value =\" Buy \" width=\"10\" align = \"center\"/></form>\n</div>" ;

                System.out.println(id);
                System.out.println(title);
                System.out.println(category);
                System.out.println(description);
                System.out.println(ImageGot);
                System.out.println(price);



           }

          return GOT = true;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GOT = false;
    }

    public boolean BuyItem(int id) {
        boolean Bought = false;
        //Запрос на добавление айтема



        try {
            Class.forName(JDBC_DRIVER);
           // Connection conn = DriverManager.getConnection(DB_Connection_String);

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO chart (id, user_name,  iditem, quantity) VALUES (NULL , ?, ?,1)";
            System.out.println(sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, GlobalVars.UserName);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            conn.commit();
            stmt.close();
            conn.close();
            Bought = true;
            return Bought;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Bought;
    }


    public boolean GetChartList (String username)
    {
        //Select quiery

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        GlobalVars.ChartlistAnswer = "";

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connection opening
            System.out.println("Connecting to database...");
           // conn = DriverManager.getConnection(DB_Connection_String);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //Query execution
            System.out.println("Creating statement...");
            stmt = conn.createStatement();




            sql = "SELECT chart.id, title, price, chart.quantity FROM items, chart WHERE chart.iditem = items.id AND chart.user_name = \"" + username +"\" AND chart.ordered = '0';";

            System.out.println(sql);
            stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);


            System.out.println("Moving cursor to the first position...");
            rs.first();
            System.out.println("Getting record...");
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String price = rs.getString("price");
            int quantity = rs.getInt("quantity");
            int number = 1;


            GlobalVars.ChartlistAnswer = "<tr><td><b><font color = \"white\">" + number + "</td><td><b><font color = \"white\">"+ title +  "</td><td><font color = \"white\"><b>" +price +"<img src=\"img/btc_small.png\" align = \"right\" width = 25px height  =25px/></td><form action=\"/order\" method=\"post\"><td><font color = \"white\"><b>" + quantity + "</td><td><input type=\"text\" name=\"Quantity\" value = \"" + quantity + "\" /><input type=\"hidden\" name=\"id\" value = \"" + id + "\" /><input type=\"submit\" name=\"Save\" value =\"Save\" width=\"10\" align = \"center\"/><td> </form> <td><form action=\"/chartlist\" method=\"post\"><input type=\"hidden\" name=\"id\" value = \""+id+"\" /><input type=\"submit\" name=\"Delete\" value =\"DELETE\" width=\"10\" align = \"center\"/></form></td></tr>";

            // for (int i = id-1; i>0; i--)
            while (rs.next())
            {
                number++;
                System.out.println("Moving cursor to the previous position...");
                // rs.previous();
                System.out.println("Getting record...");
                id = rs.getInt("id");
                title = rs.getString("title");
                price = rs.getString("price");
                quantity = rs.getInt("quantity");
                GlobalVars.ChartlistAnswer = GlobalVars.ChartlistAnswer + "<tr><td><b><font color = \"white\">" + number + "</td><td><b><font color = \"white\">"+ title +  "</td><td><font color = \"white\"><b>" +price +"<img src=\"img/btc_small.png\" align = \"right\" width = 25px height  =25px/></td><form action=\"/order\" method=\"post\"><td><font color = \"white\"><b>" + quantity + "</td><td><input type=\"text\" name=\"Quantity\" value = \"" + quantity + "\" /><input type=\"hidden\" name=\"id\" value = \"" + id + "\" /><input type=\"submit\" name=\"Save\" value =\"Save\" width=\"10\" align = \"center\"/><td> </form> <td><form action=\"/chartlist\" method=\"post\"><input type=\"hidden\" name=\"id\" value = \""+id+"\" /><input type=\"submit\" name=\"Delete\" value =\"DELETE\" width=\"10\" align = \"center\"/></form></td></tr>";
                System.out.println( GlobalVars.ChartlistAnswer);

            }
            System.out.println("\n=========================\n");
            System.out.println( GlobalVars.ChartlistAnswer);
            System.out.println("\n=========================\n");
            // Clear environment

            GlobalVars.ChartlistAnswer = GlobalVars.ChartlistAnswer + "<tr><td></td><td></td><td></td><td></td><td></td><td></td><form action=\"/order\" method=\"get\"><td><img src=\"img/ready.png\" align = \"left\" width = 40px height  =40px/><input type=\"submit\" name=\"Confirm\" value =\"Confirm order\" width=\"10\" align = \"center\"/><td> </form></tr>";
            stmt.close();
            conn.close();
            return true;


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Closing DB Connection...");


        return false;
    }





    public boolean DeleteChartItem(int id)
    {
        //Delete quiery
        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connection opening
            System.out.println("Connecting to database...");
           // conn = DriverManager.getConnection(DB_Connection_String);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //Query execution
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            sql = "DELETE FROM chart WHERE id=\"" + id + "\";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return true;


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Closing DB Connection...");
        return false;
    }



    public boolean updateQuantity(int id, int quantity)
    {
        //update quiery
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        System.out.println("YES");

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connection opening
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //conn = DriverManager.getConnection(DB_Connection_String);

            //Query execution
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            sql = "UPDATE chart SET quantity = "+ quantity+" WHERE id = "+id+";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return true;


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Closing DB Connection...");
        return false;
    }

    public boolean PlaceOrder()
    {
        //update quiery
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        System.out.println("YES");

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connection opening
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
           // conn = DriverManager.getConnection(DB_Connection_String);

            //Query execution
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            sql = "UPDATE chart SET ordered = "+1+" WHERE user_name = \""+GlobalVars.UserName+"\";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return true;


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Closing DB Connection...");
        return false;
    }





}