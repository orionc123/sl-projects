package com.hcl.controller;

import com.hcl.model.User;
import com.hcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class Main {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public String loginValid(@RequestParam("username") String name) {
        if (userService.loginValid(name)) {
            return "redirect:/main/edit/" + name;
        } else {
            return "login-fail";
        }
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @PostMapping("/edit/{name}")
    public String updateUser(@RequestParam("name") String name, @RequestParam("pass") String password, @RequestParam("email") String email) {
        if (userService.updateUser(name, password, email)) {
            return "confirm";
        } else return "edit-fail";
    }

    @GetMapping(value = "/edit/{name}")
    public ModelAndView edit(@PathVariable("name") String name) {
        User user = userService.findUser(name);
        return new ModelAndView("edit-user", "user", user);
    }

}
