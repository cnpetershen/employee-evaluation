package com.peter.smartmedicalserver.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepSeekResponse {
    private String id;
    private String object;
    private String model;
    private long created;
    private List<DeepSeekResponseChoice> choices;
    private DeepSeekUsage usage;

    @JsonProperty("system_fingerprint")
    private String systemFingerprint;

    public String getFirstChoiceContent() {
        if (choices == null || choices.isEmpty()) {
            return null;
        }
        return choices.get(0).message.getContent();
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeepSeekResponseChoice {
        private int index;
        private DeepSeekMessage message;
        @JsonProperty("finish_reason")
        private String finishReason;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeepSeekUsage {
        @JsonProperty("prompt_tokens")
        private int promptTokens;
        @JsonProperty("total_tokens")
        private int totalTokens;
        @JsonProperty("completed_tokens")
        private int completedTokens;
        @JsonProperty("prompt_cache_hit_tokens")
        private int hitTokens;
        @JsonProperty("prompt_cache_miss_tokens")
        private int missTokens;
    }
}
