package com.peter.smartmedicalserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Questions {
  private Integer id;
  private String username;
  @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
  private Date askDatetime;
  private String message;
  private String threadId;
}


