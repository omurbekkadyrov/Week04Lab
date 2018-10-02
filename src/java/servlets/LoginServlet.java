/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 759388
 */
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("username") == null)
        {
            Cookie[] cookies = request.getCookies();
            for(int i=0;i<cookies.length;i++)
            {
                if(cookies[i].getName().equals("username"))
                {
                    request.setAttribute("username", cookies[i].getValue());
                    request.setAttribute("rememberme", "checked");
                }
            }
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect("home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService usr = new UserService();
        
        if(username.equals("") || username == null || password.equals("") || password == null || (usr.login(username, password)==null))
        {
            request.setAttribute("invalidlogin", "Invalid login");
            request.setAttribute("${username}", username);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else
        {
            session.setAttribute("username", username);
            if(request.getParameter("rememberme") != null)
            {
                Cookie c = new Cookie("username", username);
                response.addCookie(c);
            }
            else
            {
                Cookie[] cookies = request.getCookies();
                for(Cookie c : cookies)
                {
                    if(c.getName().equals("username"))
                    {
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
            response.sendRedirect("home");
        }
        
    }
}
