package com.peter.smartmedicalserver.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
//@Builder
public class DeepSeekRequestMessage<T extends DeepSeekMessage> {
    private String model = "deepseek-chat";
    private boolean stream = false;

    private List<T> messages = new java.util.ArrayList<T>();

    public DeepSeekRequestMessage(List<T>  messages) {
        this.messages = messages;
    }


}
