package com.peter.smartmedicalserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personal {
    private Long id;
    private String name;
    private String idCard;
    private String phone;
    private Date birthDate;
    private String country;
    private String ethnicity;
    private String address;
    private String Photo;
    private String username;
}
