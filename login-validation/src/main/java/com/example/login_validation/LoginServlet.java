package com.example.login_validation;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");
        if(name.equals("admin") && pass.equals("admin")){
            HttpSession session = request.getSession();
            session.setAttribute("sessionName",name);
            response.sendRedirect("login-success.jsp");
        } else {
            response.sendRedirect("login-fail.html");
        }
    }
}