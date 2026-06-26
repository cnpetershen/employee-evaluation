package com.peter.smartmedicalserver.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseStatus {
    private int code;
    private String message;
    private String status;

    public static ResponseStatus success() {
        return ResponseStatus.builder().code(200).message("success").status("success").build();
    }

    public static ResponseStatus error(String message) {
        return ResponseStatus.builder().code(500).message(message).status("error").build();
    }

    public static ResponseStatus OK = success();

    public static ResponseStatus ERROR = error("Internal Server Error");

}
