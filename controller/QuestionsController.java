package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.Questions;
import com.peter.smartmedicalserver.service.QuestionsService;
import com.peter.smartmedicalserver.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dialogs")
public class QuestionsController {

    @Autowired
    private QuestionsService questionService;
    @GetMapping("/questions")
    public List<Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestionsByUsername(@PathVariable("id") int id) {
        questionService.deleteById(id);
    }

    @PutMapping("/questions/{id}")
    public ResponseStatus updateQuestions(@PathVariable("id") int id, @RequestBody Questions questions) {
        questionService.update(id, questions);
        return ResponseStatus.OK;
    }
}
