package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.ModelAndView;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;


@Controller
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login.html";
    }

    @PostMapping("/userLogin")
    public String userLogin(@ModelAttribute("user") User user){

        String userid = user.getUserId();

        User userdata = repository.findById(userid);
        
        if (user.getPassword().equals(userdata.getPassword()))
             return "home.html";
         else
             return "error.html";

    }

    @PostMapping("/register")
    public String signUp(){
        return "registration.html";
    }


}
