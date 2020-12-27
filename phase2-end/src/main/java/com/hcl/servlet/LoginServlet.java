package com.hcl.servlet;

import com.hcl.bean.User;
import com.hcl.utility.HibernateUtility;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        EntityManagerFactory entityManagerFactory=HibernateUtility.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        HttpSession session = request.getSession();

        try{
            User user = entityManager.getReference(User.class, username);
            if(user.getPassword().equals(password)){
                session.setAttribute("user",user);
                response.sendRedirect("login-success.jsp");
            } else{
                String message = "Incorrect Password.";
                session.setAttribute("errorMessage",message);
                response.sendRedirect("login-fail.jsp");
            }
        } catch (EntityNotFoundException e){
            String message = "Username does not exist.";
            session.setAttribute("errorMessage",message);
            response.sendRedirect("login-fail.jsp");
        } finally {
            entityManager.close();
        }
    }
}
