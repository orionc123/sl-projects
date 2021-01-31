package com.hcl.capstone.controller;

import com.hcl.capstone.model.Product;
import com.hcl.capstone.model.User;
import com.hcl.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginValid(HttpSession session, @RequestParam("username") String name, @RequestParam("password") String password) {
        if (userService.isValidLogin(name, password)) {
            User user = userService.getUser(name);
            session.setAttribute("currentUser", user);
            session.setAttribute("cart", new ArrayList<Product>());
            return "redirect:/home";
        } else {
            return "login-fail";
        }
    }

    @GetMapping(value = "/register")
    public String reg(){
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam("username") String name,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("phone") String phone,
                           @RequestParam("fullName") String fullName,
                           @RequestParam("streetName") String streetName,
                           @RequestParam("aptNumber") String aptNumber,
                           @RequestParam("city") String city,
                           @RequestParam("state") String state,
                           @RequestParam("country") String country,
                           @RequestParam("zip") int zip){
        if (userService.register(name, password, email, phone, fullName, streetName, aptNumber, city, state, country, zip)) {
            return "redirect:/register-success";
        } else {
            return "register-fail";
        }
    }

    @GetMapping(value = "/register-success")
    public String regSuccess(){
        return "register-success";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "logout";
    }

    @GetMapping("/update/{username}")
    public ModelAndView updateUser(HttpSession session, @PathVariable("username") String username) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            User user = userService.getUser(username);
            if (user != null) return new ModelAndView("update-user", "user", user);
            else return new ModelAndView("redirect:/home");
        } else return new ModelAndView("redirect:/home");

    }

    @PostMapping("/update/{username}")
    public String updateUserPost(HttpSession session, @PathVariable("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("fullName") String fullName,
                                 @RequestParam("streetName") String streetName,
                                 @RequestParam("aptNumber") String aptNumber,
                                 @RequestParam("city") String city,
                                 @RequestParam("state") String state,
                                 @RequestParam("country") String country,
                                 @RequestParam("zip") int zip) {
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            if (userService.updateUser(username, password, email, phone, fullName, streetName, aptNumber, city, state, country, zip)) {
                return "redirect:/admin";
            } else return "redirect:/home";
        } else return "redirect:/home";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(HttpSession session, @PathVariable("username") String username){
        if (((User) session.getAttribute("currentUser")).getUsername().equals("admin")) {
            userService.deleteUser(username);
            session.setAttribute("allUsers",userService.getAllUsers());
            return "redirect:/user-management";
        } else{
            return "redirect:/home";
        }
    }

    @PostMapping("/delete/{username}")
    public String deletePost(){
        return "";
    }

}
