/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.User;
import business.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 763198
 */
@WebServlet(name = "LoginServlet", urlPatterns =
{
    "/login"
})
public class LoginServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
        
        Cookie userCookie = null;

        if (username != null)
        {
            //check for instance of user cookie
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("username") && request.getParameter("logout") == null)
                {
                    userCookie = cookie;
//                response.sendRedirect(request.getContextPath() + "home");
                }
            }
        }

        //checks if logout
        if (request.getParameter("logout") != null)
        {
            request.setAttribute("message", "Successfully logged out");
            //DESTROY COOKIE
            if (userCookie != null)
            {
                userCookie.setMaxAge(0);
                response.addCookie(userCookie);
                userCookie = null;
            }
            if (username != null)
            {
                session.invalidate();
            }
        }

        //if user cookie exists, redirect home
        if (userCookie != null)
        {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //check credentials
        UserService userService = new UserService();
        User user = userService.login(username, password);

        //if info invalid, reload login
        if (user == null)
        {
            request.setAttribute("message", "Invalid credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();

        session.setAttribute("username", username);

        //if remember is not checked, just go to home
        if (request.getParameter("remember") == null)
        {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        if (request.getParameter("remember") != null)
        {
            //if checked, create and send cookie
            System.out.println(request.getParameter("remember"));
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(3600);
            userCookie.setPath("/");
            response.addCookie(userCookie);
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
