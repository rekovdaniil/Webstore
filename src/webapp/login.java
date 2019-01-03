package webapp;

/**
 * Created by Daniil on 12.02.2018.
 */
import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "login")
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userObject = new User();

        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));

        if (userObject.isValidUserCredentials(request.getParameter("loginname"), request.getParameter("password"))) {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else
        {
            request.setAttribute("errorMessage","<img src=\"img/error.gif\" align = \"center\" width = 200px height  =200px/><br>Invalid login or password. Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.print("login-name" + request.getParameter("loginname") + "Password:" + request.getParameter("password"));
    }
}
