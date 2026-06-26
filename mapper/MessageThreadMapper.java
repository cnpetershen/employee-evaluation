package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.MessageThread;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageThreadMapper {

    @Select("select * from message_thread where threadId = #{threadId}")
    List<MessageThread> getMessageThreadByGuid(String threadId);

    @Insert("insert into message_thread (threadId,role,username,message,askDatetime) " +
            "values (#{threadId}, #{role}, #{username}, #{message}, #{askDatetime})")
    void saveMessageThread(MessageThread messageThread);

    @Select("select * from message_thread where username = #{username} order by askDatetime desc limit 1")
    MessageThread getLatestThread(String username);

    @Select("select * from message_thread " +
            "where threadId = #{threadId} order by askDatetime")
    List<MessageThread> getHistoryThreads(String threadId);

    @Select("select * from message_thread " +
            "where username = #{username} and threadId = #{threadId}")
    List<MessageThread>  getThreadsByUsernameThreadId(String username, String threadId);
}
