package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.Personal;
import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.mapper.PersonalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {
    @Autowired
    private PersonalMapper personalMapper;
    @Autowired
    private UserService userService ;

    public void insert(Personal personal,String username) {
        User user = userService.getUserByUsername(username);
        if(user != null){
            personal.setUsername(username);
            personalMapper.insert(personal);
            return;
        }
        throw new IllegalArgumentException("User not found");
    }

    public Personal findByUsername(String username) {
        return personalMapper.findByUsername(username);
    }

    public void update(Personal personal, String username) {
        User user = userService.getUserByUsername(username);
        if(user != null){
            personal.setUsername(username);
            personalMapper.update(personal);
            return;
        }
        throw new IllegalArgumentException("User not found");
    }
}
