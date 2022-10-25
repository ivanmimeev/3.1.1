package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String allUsers(ModelMap model) {
        model.addAttribute("users", this.userService.allUser());
        return "users";
    }

    @GetMapping(value = "/add")
    public String addPage(User user) {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
