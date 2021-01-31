package com.hcl.capstone.controller;

import com.hcl.capstone.model.Product;
import com.hcl.capstone.model.User;
import com.hcl.capstone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/create-prod")
    public String createProd(HttpSession session) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            return "admin-create-product";
        } else return "redirect:/home";
    }

    @PostMapping("/create-prod")
    public String createProdPost(HttpSession session,
                                 @RequestParam("name") String name,
                                 @RequestParam("category") String category,
                                 @RequestParam("condition") String condition,
                                 @RequestParam("price") double price,
                                 @RequestParam("imageLink") String imageLink) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            if (productService.createProduct(name, category, condition, price, imageLink)) {
                session.setAttribute("allProducts", productService.getAllProducts());
                return "redirect:/inventory";
            } else return "redirect:/home";
        } else return "redirect:/home";
    }

    @GetMapping("/update-prod/{name}")
    public ModelAndView updateProd(HttpSession session, @PathVariable("name") String name) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            Product product = productService.getProduct(name);
            if (product != null) return new ModelAndView("admin-update-product", "product", product);
            else return new ModelAndView("redirect:/home");
        } else return new ModelAndView("redirect:/home");
    }

    @PostMapping("/update-prod/{name}")
    public String updateProdPost(HttpSession session, @PathVariable("name") String name,
                                 @RequestParam("category") String category,
                                 @RequestParam("condition") String condition,
                                 @RequestParam("price") double price,
                                 @RequestParam("imageLink") String imageLink) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            if (productService.updateProduct(name, category, condition, price, imageLink)) {
                session.setAttribute("allProducts", productService.getAllProducts());
                return "redirect:/inventory";
            } else return "redirect:/home";
        } else return "redirect:/home";
    }

    @GetMapping("/delete-prod/{name}")
    public String deleteProd(HttpSession session, @PathVariable("name") String name) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            productService.deleteProduct(name);
            session.setAttribute("allProducts", productService.getAllProducts());
            return "redirect:/inventory";
        } else return "redirect:/home";
    }

    @GetMapping("/remove-prod/{name}")
    public String removeProd(HttpSession session, @PathVariable("name") String name) {
        Product toRemove = productService.getProduct(name);
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        for(Product p : cart){
            if(p.getName().equals(toRemove.getName())){
                cart.remove(p);
                break;
            }
        }
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }
}
