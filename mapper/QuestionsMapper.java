package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.Questions;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionsMapper {
    @Select("SELECT id,username,askDatetime,message FROM message_thread where role = 'user'")
    List<Questions> getAllQuestions();

    @Delete("DELETE FROM message_thread WHERE id = #{id}")
    void deleteById(int id);

    @Select("SELECT id,username,askDatetime,message,threadId FROM message_thread WHERE id = #{id}")
    Questions getById(int id);

    @Select("SELECT  id,username,askDatetime,message,threadId FROM message_thread WHERE threadId = #{threadId} AND id > #{id} and role = 'system' limit 1")
    Questions getAnswersByThreadIdAndQuestionId(String threadId, int id);

    @Update("UPDATE message_thread SET message = #{questions.message} WHERE id = #{id}")
    void update(int id, Questions questions);


}
