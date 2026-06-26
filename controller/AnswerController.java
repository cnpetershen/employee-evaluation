package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.Answer;
import com.peter.smartmedicalserver.service.AnswerService;
import com.peter.smartmedicalserver.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dialogs")
public class AnswerController {

    @Autowired
    private AnswerService answerService;




    @GetMapping("/answer")
    public List<Answer> getAllAnswer() {
        return answerService.getAllAnswer();
    }
    @DeleteMapping("/answer/{id}")
    public void deleteQuestionsByUsername(@PathVariable("id") int id) {
        answerService.deleteById(id);
    }

}
