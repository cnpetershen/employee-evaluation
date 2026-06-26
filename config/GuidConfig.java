package com.peter.smartmedicalserver.config;

import com.peter.smartmedicalserver.utils.GuidUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuidConfig {
    @Bean
    public GuidUtil guidUtil() {
        return new GuidUtil();
    }
}
