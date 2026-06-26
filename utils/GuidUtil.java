package com.peter.smartmedicalserver.utils;

public class GuidUtil {
    public String generateGuid() {
        return java.util.UUID.randomUUID().toString();
    }
}
