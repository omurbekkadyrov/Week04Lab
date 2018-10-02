/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 759388
 */
public class HomeServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession username = request.getSession();
        
        if(!(request.getParameter("logout") == null))
        {
            username.setAttribute("username", null);
            request.setAttribute("invalidlogin", "You have successfully logged out.");
            request.getSession().invalidate();
            response.sendRedirect("login");
        }
        else if(username.getAttribute("username") == null)
        {
            response.sendRedirect("login");
        }
        else if(!(username.getAttribute("username") == null))
        {
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
