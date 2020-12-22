package com.example.product_details;

import beans.Product;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = new Product(
                request.getParameter("name"),
                request.getParameter("brand"),
                request.getParameter("description"),
                request.getParameter("price"));
        //start session for this product
        HttpSession session = request.getSession();
        session.setAttribute("product",product);
        response.sendRedirect("view-product.jsp");
    }
}