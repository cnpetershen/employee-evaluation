package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.mapper.UserManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageService {
    @Autowired
    private UserManageMapper userManageMapper;
    public List<User> getAllUser() {
        return userManageMapper.getAllUser();
    }
    public void addUser(User user) {
        userManageMapper.addUser(user);
    }

    public void deleteUserByUsername(String username) {
        userManageMapper.deleteUserByUsername(username);
    }
    public void updateUser(User user, String oldUsername) {
        userManageMapper.updateUser(user, oldUsername);
    }
}
