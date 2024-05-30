package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session != null && session.getAttribute("username")!=null){
            String username = (String)session.getAttribute("username");

            resp.setContentType("text/html");
            resp.getWriter().println("<html><body>");
            resp.getWriter().println("<h1>Welcome, " + username + "!</h1>");
            resp.getWriter().println("<a href='logout'>Logout</a>");
            resp.getWriter().println("</body></html>");
        } else {
            resp.sendRedirect("login.html");
        }
    }
}
