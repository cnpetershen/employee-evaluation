package com.peter.smartmedicalserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceDetail {
    private Integer id;
    private String name;
    private String telephone;
    private String granduate;
    private String title;
    private String specialty;
    private String achievements;
    private String communication;
    private String award;
    private String experience;

}
