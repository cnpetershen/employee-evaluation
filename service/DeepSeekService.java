package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.utils.JsonUtil;
import com.peter.smartmedicalserver.vo.DeepSeekMessage;
import com.peter.smartmedicalserver.vo.DeepSeekRequestMessage;
import com.peter.smartmedicalserver.vo.DeepSeekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class DeepSeekService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DEEPSEEK_API_URL = "https://api.deepseek.com/chat/completions";

    public <T extends DeepSeekMessage> String sendRequest(List<T> messages) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer DEEPSEEK_API_KEY");
        DeepSeekRequestMessage<T> requestBody = new DeepSeekRequestMessage<>(messages);
        HttpEntity<DeepSeekRequestMessage<T>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<DeepSeekResponse> response = restTemplate.exchange(
                DEEPSEEK_API_URL,
                HttpMethod.POST,
                request,
                DeepSeekResponse.class
        );
        String firstChoiceContent = Objects.requireNonNull(response.getBody()).getFirstChoiceContent();
        System.out.println(firstChoiceContent);
        return firstChoiceContent;
    }
}