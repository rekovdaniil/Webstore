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

@WebServlet(name = "chartlist")
public class chartlist extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Item Item_odject = new Item();
        if (Item_odject.GetChartList(GlobalVars.UserName)) {
            request.setAttribute("chartlist", GlobalVars.ChartlistAnswer);
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        } else {
            request.setAttribute("chartlist", "<h1 align = \"center\"><font color = \"red\">The chart seems to be empty!</h1>");
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Item Item_odject = new Item();
        System.out.println(request.getParameter("id"));
        if (Item_odject.DeleteChartItem(Integer.parseInt(request.getParameter("id")))) {
            request.setAttribute("chartlist", GlobalVars.ChartlistAnswer);
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        } else {
            request.setAttribute("chartlist", "<h1 align = \"center\"><font color = \"red\">The chart seems to be empty!</h1>");
            request.getRequestDispatcher("/chart.jsp").forward(request, response);
        }


    }


}
