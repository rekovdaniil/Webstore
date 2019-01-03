package webapp;

/**
 * Created by Daniil on 14.02.2018.
 */
import appLayer.GlobalVars;
import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import dataLayer.DB_user;

@WebServlet(name = "userslist")
public class userslist extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userObject = new User();
        if(userObject.GetAllUsers()) {
            request.setAttribute("UsersList", GlobalVars.UserListAnswer);
            request.getRequestDispatcher("/userslist.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("UsersList","An error occures wile quiery execution");
            request.getRequestDispatcher("/userslist.jsp").forward(request, response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userObject = new User();

        if(userObject.deleteUser(Integer.parseInt(request.getParameter("id"))))
        {
            request.getRequestDispatcher("/userslist.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("error","An error occures while DELETE quiery execution");
        }

    }
}