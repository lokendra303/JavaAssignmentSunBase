package com.sunbase.javaassignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.equals("test@sunbasedata.com") && password.equals("Test@123")){
            request.getRequestDispatcher("/authentication").forward(request, response);
        }else {
            session.setAttribute("FailedMsg","Invalid Email or Password !");
            response.sendRedirect("login.jsp");
        }


    }
}