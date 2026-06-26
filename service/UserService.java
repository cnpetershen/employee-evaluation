package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User login(String username, String password) {
        User user = userMapper.select(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean register(User user) {
        // 检查用户名是否已存在
        if (userMapper.select(user.getUsername())!= null) {
            return false;
        }
        user.setRole("user"); // 默认注册为普通用户
        // 插入用户信息
        return userMapper.insert(user)>0;
    }

    public User getUserByUsername(String username) {
        return userMapper.select(username);
    }

    public void updateLastLogin(int id) {
        // 更新用户最后登录时间
        Date currentDate = new Date();
        userMapper.updateLastLogin(id, currentDate);
    }

    public boolean existsByUsername(String username) {
        return getUserByUsername(username)!= null;
    }

    public List<Map<String, Object>> getLoginStats() {
        return userMapper.getLoginStatus();
    }

    public List<Map<String, Object>> getQuestionStatus() {
        return userMapper.getQuestionStatus();
    }

    public List<Map<String, Object>> getAnswerStatus() {
        return userMapper.getAnswerStatus();
    }

    public int getViewStatus() {
        return userMapper.getViewStatus();
    }

    public int getQuestionCount() {
        return userMapper.getQuestionCount();
    }

    public int getAnswerCount() {
        return userMapper.getAnswerCount();
    }
}
