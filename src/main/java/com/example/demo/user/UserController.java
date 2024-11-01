package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public Void createUser(@ModelAttribute User user) {
        System.out.println("HEYYYYYYYYYYYYYYYYYYY, THIS IS USERRRRRR: " + user.getName());
        userService.saveUser(new User(user.getName(), user.getAge()));
        return null;
    }

    @DeleteMapping("/{id}")
    public Void deleteUser(@PathVariable("id") long id) {
        System.out.println("HEYYYYYYYYYYYYYYYYYYY, THIS IS ID: " + id);
        userService.deleteUser(id);
        return null;
    }
}