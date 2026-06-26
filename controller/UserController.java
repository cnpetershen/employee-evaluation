package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.Personal;
import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.service.PersonalService;
import com.peter.smartmedicalserver.service.UserService;
import com.peter.smartmedicalserver.utils.JwtUtil;
import com.peter.smartmedicalserver.vo.UserLoginStatus;
import com.peter.smartmedicalserver.vo.UserRegistrationStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    private PersonalService personalService;
    @Autowired
    private JwtUtil jwtUtil;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserLoginStatus login(@RequestBody @NotNull User user) {
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());

        if (loggedInUser != null) {
            Personal personal=personalService.findByUsername(user.getUsername());
            UserLoginStatus status= new UserLoginStatus(true,
                    jwtUtil.generateToken(loggedInUser.getUsername()),loggedInUser.getUsername(),
                    loggedInUser.getRole());
            status.setName(user.getUsername());
            userService.updateLastLogin(loggedInUser.getId());
            return status;
        } else {
            return new UserLoginStatus(false, "Invalid username or password", "", "");
        }
    }
    @PostMapping("/register")
    public UserRegistrationStatus register(@RequestBody User user) {
        userService.register(user);
        return new UserRegistrationStatus(true, "Registration successful");
    }

    @GetMapping("/login-status")
    public List<Map<String, Object>> getLoginStats() {
        List resultSet = userService.getLoginStats();
        return resultSet;
    }

    @GetMapping("/question-status")
    public List<Map<String, Object>> getQuestionStatus() {
        return userService.getQuestionStatus();
    }

    @GetMapping("/answer-status")
    public List<Map<String, Object>> getAnswerStatus() {
        return userService.getAnswerStatus();
    }

    @GetMapping("/view-status")
    public int getViewStatus() {
        return userService.getViewStatus();
    }
    @GetMapping("/question-count")
    public int getQuestionCount() {
        return userService.getQuestionCount();
    }
    @GetMapping("/answer-count")
    public int getAnswerCount() {
        return userService.getAnswerCount();
    }


}
