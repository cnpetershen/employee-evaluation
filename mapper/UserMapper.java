package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper {
    @Select("SELECT id,username,password,role,latestLoginTime FROM user where username = #{username}")
    User select(@Param("username") String username);
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    int insert(User user);


    @Update("UPDATE user SET latestLoginTime = #{currentDate} WHERE id = #{id}")
    void updateLastLogin(int id, Date currentDate);
    @Select("SELECT DATE(latestLoginTime) AS loginDate, DAYOFWEEK(latestLoginTime) AS dayOfWeek,  COUNT(*) AS loginCount " +
                   "FROM user " +
                   "GROUP BY DATE(latestLoginTime),DAYOFWEEK(latestLoginTime)" +
            "ORDER BY dayOfWeek")
    List<Map<String, Object>> getLoginStatus();

    @Select("select DATE(askDateTime) AS loginDate, DAYOFWEEK(askDateTime) AS dayOfWeek,  COUNT(*) AS questionCount " +
            "from message_thread " +
            "where role = 'user' " +
            "GROUP BY DATE(askDateTime), DAYOFWEEK(askDateTime) " +
            "ORDER BY dayOfWeek")
    List<Map<String, Object>> getQuestionStatus();

    @Select("select DATE(askDateTime) AS loginDate, DAYOFWEEK(askDateTime) AS dayOfWeek,  COUNT(*) AS answerCount " +
            "from message_thread " +
            "where role = 'system' " +
            "GROUP BY DATE(askDateTime), DAYOFWEEK(askDateTime) " +
            "ORDER BY dayOfWeek")
    List<Map<String, Object>> getAnswerStatus();

@Select("SELECT COUNT(*) AS viewCount \n" +
        "FROM user\n" +
        "WHERE DATE(latestLoginTime) = CURDATE();")
    int getViewStatus();
@Select("SELECT COUNT(*) AS questionCount \n" +
        "FROM message_thread\n" +
        "WHERE role = 'user' AND DATE(askDateTime) = CURDATE();")
    int getQuestionCount();
@Select("SELECT COUNT(*) AS answerCount \n" +
            "FROM message_thread\n" +
            "WHERE role = 'system' AND DATE(askDateTime) = CURDATE();")
    int getAnswerCount();
}
