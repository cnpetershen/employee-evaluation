package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class UserManageController {
    @Autowired
    private UserManageService userManageService;
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userManageService.getAllUser();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userManageService.addUser(user);
        return user;
    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userManageService.deleteUserByUsername(username);
    }
    @PutMapping("/users/{oldUsername}")
    public void updateUser(@PathVariable String oldUsername, @RequestBody User user) {
        userManageService.updateUser(user, oldUsername);
    }
}
