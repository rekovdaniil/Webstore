package webapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;



import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;



/**
 * Created by Daniil on 14.02.2018.
 */

import appLayer.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import static java.lang.System.out;

@WebServlet(name = "additem")
@MultipartConfig(fileSizeThreshold = 6291456, // 6 MB
        maxFileSize = 10485760L, // 10 MB
        maxRequestSize = 20971520L) // 20 MB
public class additem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      out.println("It will work soon....");

      out.println(request.getParameter("title"));
        out.println(request.getParameter("category"));
        out.println(request.getParameter("description"));
        out.println(request.getParameter("illustration"));
        out.println(request.getParameter("price"));
        Part filepart = request.getPart("illustration");

      Item item_object = new Item();
        if (request.getParameter("title")!= "" || request.getParameter("category")!= "" || request.getParameter("description")!= ""  || request.getParameter("price")!= "" || Integer.parseInt(request.getParameter("price")) > 0 )
         {
           if(item_object.RegisterNewItem(request.getParameter("title"), request.getParameter("category"), request.getParameter("description"), request.getParameter("illustration"), request.getParameter("price"), filepart ))
           {
               request.setAttribute("error","The item has been successfully added!");
               request.getRequestDispatcher("/additem.jsp").forward(request, response);
           }
           else
               {
                   request.setAttribute("error","Error while query execution!");
                   request.getRequestDispatcher("/additem.jsp").forward(request, response);
               }
        }
        else
        {
            request.setAttribute("error","You must fulfill the form correctly!");
            request.getRequestDispatcher("/additem.jsp").forward(request, response);
        }
    }
   }

