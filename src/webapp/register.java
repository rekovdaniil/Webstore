package webapp;

/**
 * Created by Daniil on 13.02.2018.
 */
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

    @WebServlet(name = "register")
    public class register extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            User userObject = new User();

            request.setAttribute("username", request.getParameter("loginname"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("Re-password", request.getParameter("Re-password"));
            request.setAttribute("Name", request.getParameter("Name"));
            request.setAttribute("Surname", request.getParameter("Surname"));

            if(userObject.isValidRegistrationData(request.getParameter("loginname"), request.getParameter("password"), request.getParameter("Re-password"), request.getParameter("Name"), request.getParameter("Surname")))
            {
                //insert request passed
                System.out.println("Registration Complete!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("errorMessage","<img src=\"img/error.gif\" align = \"center\" width = 200px height  =200px/><br><u>Inserted data is not fulfill the criterion:</u> <br> At least 6 latin characters in LOGIN <br> Just latin characters and numbers in PASSWORD <br> PASSWORDS must be equal <br>  Try again...");
                request.getRequestDispatcher("/register.jsp").forward(request, response);

            }

        }

}
