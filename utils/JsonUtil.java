package com.peter.smartmedicalserver.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
