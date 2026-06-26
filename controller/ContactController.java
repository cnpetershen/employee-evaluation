package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.MessageThread;
import com.peter.smartmedicalserver.service.ContactService;
import com.peter.smartmedicalserver.vo.ThreadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @PostMapping("/start")
    public ThreadInfo start() {
        return new ThreadInfo(contactService.startThread(),"new thread");
    }
    @PostMapping("/ask/{username}/{threadId}")
    public String ask(@PathVariable String threadId,
                      @PathVariable String username,
                      @RequestBody MessageThread thread) {
        return contactService.sendQuestion(threadId, username, thread.getMessage());
    }

    @GetMapping("/history/{username}/{threadId}")
    public List<MessageThread> history(@PathVariable String username, @PathVariable String threadId) {
        if(!contactService.threadExists(username, threadId))
            throw new IllegalArgumentException("Thread does not exist");
        return contactService.getHistoryThreads(threadId);
    }

    @GetMapping("/history/{username}/threadId")
    public ThreadInfo getLatestThreadId( @PathVariable String username) {
        return new ThreadInfo(contactService.getLatestThreadId(username),"latest thread id");
    }
}
