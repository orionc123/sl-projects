package com.example.add_product;

import com.example.bean.Product;

import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "validatorServlet", value = "/validator-servlet")
public class ValidatorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Product product = new Product();
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        boolean success;
        if(name.equals("")||brand.equals("")||description.equals("")||price.equals("")){
            success = false;
        } else{
            product.setName(name);
            product.setBrand(brand);
            product.setDescription(description);
            product.setPrice(price);
            success = true;
        }

        if(success){
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            response.sendRedirect("add-success.html");
        } else {
            //handle missing data field
            response.sendRedirect("add-fail.html");
        }
    }
}