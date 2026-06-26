package com.peter.smartmedicalserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        // add additional configuration here if needed
        // 获取现有的消息转换器
        List<HttpMessageConverter<?>> messageConverters = template.getMessageConverters();

        // 添加 Jackson 消息转换器
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));// 设置支持的媒体类型

        messageConverters.add(converter);

        // 设置消息转换器
        template.setMessageConverters(messageConverters);
        return template;
    }
}
