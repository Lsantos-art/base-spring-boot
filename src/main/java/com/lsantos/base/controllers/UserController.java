package com.lsantos.base.controllers;

import com.lsantos.base.exceptions.UserAlreadyExistExceptio;
import com.lsantos.base.models.User;
import com.lsantos.base.services.UserRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class UserController {

    @Autowired
    UserRegisterService authService;


    // New User
    @GetMapping("/add-user")
    public ModelAndView addUser() {
        ModelAndView mv = new ModelAndView("Auth/create");
        return mv;
    }

    // Create User
    @PostMapping("/add-user")
    public ModelAndView insertUser(User user) throws UserAlreadyExistExceptio {
        User saveUser = authService.saveUser(user);
        ModelAndView mv = new ModelAndView("Auth/create");
        return mv;
    }

    //Index(After logged) 
    @PostMapping("/home")
    public String redirect() {
        return "redirect:/home";
    }

    //Index(After logged) 
    @GetMapping("/home")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
