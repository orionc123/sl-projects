package com.hcl.phase3end.controller;

import com.hcl.phase3end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String loginValid(@RequestParam("username") String name,@RequestParam("password") String password) {
        if (userService.isValidLogin(name, password)) {
            return "redirect:/display-tasks";
        } else {
            return "user-login-fail";
        }
    }

    @GetMapping(value = "/login")
    public String login() {
        return "user-login";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam("username") String name,@RequestParam("password") String password, @RequestParam("email") String email) {
        if (userService.register(name, password,email)) {
            return "redirect:/login";
        } else {
            return "user-register-fail";
        }
    }

    @GetMapping(value = "/register")
    public String reg(){
        return "user-register";
    }
}
