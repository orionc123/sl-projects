package com.hcl.servlet;

import com.hcl.bean.User;
import com.hcl.utility.HibernateUtility;

import java.io.*;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "registrationServlet", value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {
    String regex = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\w\\d]).*$";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityManagerFactory entityManagerFactory = HibernateUtility.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String confirmPass = request.getParameter("conf-pass");
        String email = request.getParameter("email");

        try {
            if (!Pattern.compile(regex).matcher(password).matches()) {
                String message = "Password must contain 1 uppercase, 1 lowercase, 1 number, and 1 special character.";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", message);
                response.sendRedirect("registration-fail.jsp");
            } else if (!password.equals(confirmPass)) {
                String message = "Passwords do not match.";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", message);
                response.sendRedirect("registration-fail.jsp");
            } else {
                User u = entityManager.find(User.class, username);
                if (u != null) {
                    String message = "User already exists.";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", message);
                    response.sendRedirect("registration-fail.jsp");
                } else {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    entityManager.getTransaction().begin();
                    entityManager.persist(user);
                    entityManager.getTransaction().commit();
                    response.sendRedirect("registration-success.jsp");
                }
            }
        } finally {
            entityManager.close();
        }
    }
}