package webapp;

/**
 * Created by Daniil on 13.02.2018.
 */
import appLayer.GlobalVars;
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

@WebServlet(name = "order")
public class order extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Item itemObject = new Item();
        if(itemObject.updateQuantity(Integer.parseInt((request.getParameter("id"))),Integer.parseInt(request.getParameter("Quantity")))) {
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("error","An error occurs wile query execution");
            request.getRequestDispatcher("/cahrt.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Item itemObject = new Item();
        if(itemObject.PlaceOrder()) {
            request.setAttribute("error","An order has been successfully confirmed!");
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("error","An error occurs wile query execution");
            request.getRequestDispatcher("/cahrt.jsp").forward(request, response);
        }


    }
}