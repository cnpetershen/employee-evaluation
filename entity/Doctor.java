package com.peter.smartmedicalserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private Integer id;
    private String name;
    private String department;
    private String specialty;
    private String photoUrl;
    private String telephone;
    private String granduate;
    private String position;
}
