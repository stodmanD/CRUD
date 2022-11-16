package org.stolypin.pp231crud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.stolypin.pp231crud.model.User;
import org.stolypin.pp231crud.web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping ("/user")
    public String allUser (Model model){
        List <User> allUser = userService.getAllUsers();
        model.addAttribute("allUsers", allUser);

        return "allUser";
    }
    @GetMapping("/addUser")
    public String addUser (Model model) {
        User user = new User();
        model.addAttribute("User", user);
    return "UserInfo";
    }
    @PostMapping("/saveUser")
    public String saveUser (@ModelAttribute ("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }
    @GetMapping("/edit/{id}")
    public String updateUser (@PathVariable ("id") int id, Model model ){
        User user = userService.getUser(id);
        model.addAttribute("User", user);
        return "UserInfo";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser (@PathVariable ("id") int id){
        userService.deleteUser(id);
        return "redirect:/user";
    }

}
