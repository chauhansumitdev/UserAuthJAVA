package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        System.out.println(username +" "+ password);

        if("admin".equals(username) && "1234".equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("welcome");

        }else{
            resp.sendRedirect("error.html");
        }
    }
}
