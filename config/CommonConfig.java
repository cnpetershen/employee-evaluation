package com.peter.smartmedicalserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CommonConfig {
    @Bean //将创建好的对象交给Spring管理，后期方便调用
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
