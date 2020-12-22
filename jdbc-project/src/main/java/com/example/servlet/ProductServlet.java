package com.example.servlet;

import com.example.model.Product;
import com.example.service.ProductService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        ProductService productService = new ProductService();
        int pid = 1;
        try{
            pid = Integer.parseInt(request.getParameter("pid"));
        } catch (Exception e){
            out.println("<h1>Error: You've entered an invalid id. By default, the ID has been set to 1.</h1><br>");
        }

        Product p = productService.seeProduct(pid);

        if(p != null) out.println("<h1>" + p + "</h1>");
        else {
            out.println("<h1>Error: Sorry, this product is not available</h1>");
        }
        out.println("</body></html>");
    }
}