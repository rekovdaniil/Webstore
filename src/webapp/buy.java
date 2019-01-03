package webapp;

/**
 * Created by Daniil on 13.02.2018.
 */
import appLayer.Item;
import appLayer.User;
import dataLayer.DB_user;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "buy")
public class buy extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  System.out.println(request.getParameter("id"));

        Item itemObject = new Item();

        if(itemObject.Buy(Integer.parseInt(request.getParameter("id"))))
        {
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("error","An error occures while BUY execution");
        }


    }

}