package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.MessageThread;
import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.mapper.MessageThreadMapper;
import com.peter.smartmedicalserver.utils.GuidUtil;
import com.peter.smartmedicalserver.vo.DeepSeekMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    private DeepSeekService deepSeekService;
    @Autowired
    private GuidUtil guidUtil;

    @Autowired
    private MessageThreadMapper messageThreadMapper;//history messages management

    @Autowired
    private UserService userService; //user management
    public String startThread() {
        // make guid as thread id and return it
        return guidUtil.generateGuid();
    }

    public String getLatestThreadId(String username){
        MessageThread messageThread = messageThreadMapper.getLatestThread(username);
        if(messageThread == null) return startThread();
        return messageThread.getThreadId();
    }
    public String sendQuestion(String threadId, String username, String message) {
        // check user exists
        User user = userService.getUserByUsername(username);
        if(user == null) throw new IllegalArgumentException("User not found");
        //get the user message thread by guid
        List<MessageThread> messageThreads = messageThreadMapper.getMessageThreadByGuid(threadId);
        //create new message thread and save it
        MessageThread messageThread = new MessageThread(
                threadId, "user", username, message, new Date()
        );
        messageThreadMapper.saveMessageThread(messageThread);//save message to db
        messageThreads.add(messageThread);

            messageThread = new MessageThread(
                    threadId, "system", "deepseek", "你是健康专家，可以提供健康咨询。", new Date()
            );
        messageThreads.add(0, messageThread);//AI角色设定

        // reformat message to deepseek ai
        List<DeepSeekMessage> messages = new ArrayList<>();
        for (MessageThread thread : messageThreads) {
            DeepSeekMessage deepSeekMessage = new DeepSeekMessage(thread.getRole(),thread.getMessage());
            messages.add(deepSeekMessage);
        }
        String response = deepSeekService.sendRequest(messages);
        messageThread = new MessageThread(
                threadId,"system",username,response,new Date()
        );
        messageThreadMapper.saveMessageThread(messageThread);
        //add message to thread
        return response;
    }

    public List<MessageThread> getHistoryThreads(String threadId) {
        return messageThreadMapper.getHistoryThreads(threadId);
    }

    public boolean threadExists(String username, String threadId) {
        if(!userService.existsByUsername(username)) throw new IllegalArgumentException("User not found");
        List<MessageThread> threads = messageThreadMapper.getThreadsByUsernameThreadId(username, threadId);
        return !threads.isEmpty();
    }
}
