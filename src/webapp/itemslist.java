package webapp;

/**
 * Created by Daniil on 17.02.2018.
 */
import appLayer.GlobalVars;
import appLayer.Item;
import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import dataLayer.DB_user;

@WebServlet(name = "itemslist")
public class itemslist extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Item Item_odject = new Item();
        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));
        if (Item_odject.GetAllItems())
        {
            request.setAttribute("itemslist", GlobalVars.ItemsListAnswer);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }

    }
}