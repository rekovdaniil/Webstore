
package dataLayer;

import appLayer.GlobalVars;

import java.sql.*;
/**
 * Created by Daniil on 13.02.2018.
 */

public class DB_user {

    // JDBC driver Name and Database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/buildingstore";
    static final String USER = "webappuser";
    static final String PASS = "enuter74";
  //  String DB_Url = System.getProperty("JDBC_CONNECTION_STRING");
 //   String DB_User = System.getProperty("JDBC_USER");
  //  String DB_Password = System.getProperty("JDBC_PASSWORD");
 //   String DB_Connection_String = DB_Url + "?user=" + DB_User + "&password=" + DB_Password;


    public boolean isValidUserLogin(String sUserName, String sUserPassword) {
        boolean isValidUSer = false;

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

            sql = "SELECT * FROM users WHERE user_name = \"" + sUserName + "\" AND user_password = \"" + sUserPassword + "\"";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            //extraction of the data from the result set
            if (rs.next()) {
                isValidUSer = true;
                GlobalVars.UserName = sUserName;
                GlobalVars.UserID = rs.getString("id");
            }
            // Clear environment
            rs.close();
            stmt.close();
            conn.close();


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
        return isValidUSer;
    }

    public boolean isValidUserRegistration(String sLogin, String sPassword, String rePassword, String Name, String SurName) {
        boolean isValidRegistration = false;

        if (sPassword.equals(rePassword) && sLogin != "" && sPassword != "" && Name != "" && SurName != "" && sPassword.length() >= 6 && sLogin.length() >= 6) {

            isValidRegistration = true;
            Connection conn = null;
            Statement stmt = null;
            String sql = "";

            try {
                //Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                //Connection opening
                System.out.println("Connecting to database...");
                //conn = DriverManager.getConnection(DB_Connection_String);

                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //Query execution
                System.out.println("Creating statement...");
                stmt = conn.createStatement();

                sql = "INSERT INTO users VALUES (NULL,\"" + sLogin + "\",\""+ sPassword + "\",\""+ Name + "\",\""+ SurName  + "\");";

                System.out.println(sql);
                stmt.executeUpdate(sql);

                // Clear environment


                stmt.close();
                conn.close();


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
        }
        return isValidRegistration;
    }
    public boolean GetAllUsers ()
    {
        //Select quiery

        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        GlobalVars.UserListAnswer = "";

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

            sql = "SELECT * FROM users;";

            System.out.println(sql);
            stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);


            System.out.println("Moving cursor to the last position...");
            rs.last();
            System.out.println("Getting record...");
            int id = rs.getInt("id");
            String name = rs.getString("user_name");
            String Password = rs.getString("user_password");
            String RealName = rs.getString("user_realname");
            String Surname = rs.getString("user_surname");




            GlobalVars.UserListAnswer = "<tr><td><b><font color = \"white\">"+ id +  "</td><td><font color = \"white\"><b>" +name +"</td><td><font color = \"white\"><b>" +Password +"</td><td><font color = \"white\"><b>" +RealName +"</td><td><font color = \"white\"><b>" +Surname +"</td>"+ "<td><p><font color = \"white\"><form action=\"/userslist\" method=\"post\"><input type=\"hidden\" name=\"id\" value = \""+id+"\" /><input type=\"submit\" name=\"Delete\" value =\"DELETE\" width=\"10\" align = \"center\"/></form>" +"</td></tr>";

           // for (int i = id-1; i>0; i--)
            while (rs.previous())
            {
                System.out.println("Moving cursor to the previous position...");
               // rs.previous();
                System.out.println("Getting record...");
                id = rs.getInt("id");
                name = rs.getString("user_name");
                Password = rs.getString("user_password");
                RealName = rs.getString("user_realname");
                Surname = rs.getString("user_surname");
                GlobalVars.UserListAnswer = "<tr><td><font color = \"white\"><b>"+ id +  "</td><td><font color = \"white\"><b>" +name +"</td><td><font color = \"white\"><b>" +Password +"</td><td><font color = \"white\"><b>" +RealName +"</td><td><font color = \"white\"><b>" +Surname+"</td>"+ "<td><p><font color = \"white\"><form action=\"/userslist\" method=\"post\"><input type=\"hidden\" name=\"id\" value = \""+id+"\" /><input type=\"submit\" name=\"Delete\" value =\"DELETE\" width=\"10\" align = \"center\"/></form>" + "</td></tr>" + GlobalVars.UserListAnswer ;
                //System.out.println(i);

                System.out.println( GlobalVars.UserListAnswer);

            }


            System.out.println("\n=========================\n");
            System.out.println( GlobalVars.UserListAnswer);
            System.out.println("\n=========================\n");

            // Clear environment


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

    public boolean DeleteUser (int id)
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

            sql = "DELETE FROM users WHERE id=\"" + id + "\";";

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





