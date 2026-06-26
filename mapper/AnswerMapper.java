package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerMapper {
    @Select("SELECT id,askDatetime,message FROM message_thread where role = 'system'")
    List<Answer> getAllAnswer();
}
