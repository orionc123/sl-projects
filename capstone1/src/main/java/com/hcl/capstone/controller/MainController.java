package com.hcl.capstone.controller;

import com.hcl.capstone.model.Product;
import com.hcl.capstone.model.User;
import com.hcl.capstone.service.ProductService;
import com.hcl.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String homePost() {
        return "";
    }

    @GetMapping("/products")
    public String prods(HttpSession session) {
        session.setAttribute("allProducts",productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public void prodsPost(HttpSession session, @RequestParam("nameOfAdded") String pName) {
        Product product = productService.getProduct(pName);
        List<Product> updatedCart = (List<Product>)session.getAttribute("cart");
        updatedCart.add(product);
        session.setAttribute("cart",updatedCart);
    }

    @GetMapping("/admin")
    public String admin(HttpSession session) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            return "admin-hub";
        } else {
            return "redirect:/home";
        }

    }

    @PostMapping("/admin")
    public String adminPost() {
        return "";
    }

    @GetMapping("/inventory")
    public String adminInv(HttpSession session) {
        session.setAttribute("allProducts",productService.getAllProducts());
        return "admin-product-inventory";
    }

    @PostMapping("/inventory")
    public String adminInvPost() {
        return "";
    }

    @GetMapping("/user-management")
    public String adminUserMan(HttpSession session) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            session.setAttribute("allUsers", userService.getAllUsers());
            return "admin-user-management";
        } else {
            return "redirect:/home";
        }

    }

    @PostMapping("/user-management")
    public String adminUserManPost() {
        return "";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session){
        if (((User) session.getAttribute("currentUser")) != null) {
            return "cart";
        } else return "redirect:/home";
    }

    @PostMapping("/cart")
    public String cartPost(HttpSession session){
        return "";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session){
        if (((User) session.getAttribute("currentUser")) != null) {
            return "checkout";
        } else return "redirect:/home";
    }

    @PostMapping("/checkout")
    public String checkoutPost(HttpSession session, @RequestParam("fullName") String fullName,
                               @RequestParam("streetName") String streetName,
                               @RequestParam("aptNumber") String aptNumber,
                               @RequestParam("city") String city,
                               @RequestParam("state") String state,
                               @RequestParam("country") String country,
                               @RequestParam("zip") int zip){
        if (((User) session.getAttribute("currentUser")) != null) {
            User user = (User) session.getAttribute("currentUser");
            user.setFullName(fullName);
            user.setStreetName(streetName);
            user.setAptNumber(aptNumber);
            user.setCity(city);
            user.setState(state);
            user.setCountry(country);
            user.setZip(zip);
            session.setAttribute("currentUser",user);
            return "redirect:/confirmation";
        } else return "redirect:/home";
    }

    @GetMapping("/confirmation")
    public String orderConfirmation(HttpSession session){
        if (((User) session.getAttribute("currentUser")) != null) {
            return "checkout-conf";
        } else return "redirect:/home";
    }

    @PostMapping("/confirmation")
    public String confirmationPost(HttpSession session){
        if (((User) session.getAttribute("currentUser")) != null) {
            return "redirect:/complete";
        } else return "redirect:/home";
    }

    @GetMapping("/complete")
    public String orderComplete(HttpSession session){
        if (((User) session.getAttribute("currentUser")) != null) {
            return "checkout-thankyou";
        } else return "redirect:/home";
    }
}
