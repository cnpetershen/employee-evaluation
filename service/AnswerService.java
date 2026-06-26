package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.Answer;
import com.peter.smartmedicalserver.mapper.AnswerMapper;
import com.peter.smartmedicalserver.mapper.QuestionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuestionsMapper questionsMapper;

    public List<Answer> getAllAnswer() {
        return answerMapper.getAllAnswer();
    }

    public void deleteById(int id) {
        questionsMapper.deleteById(id);
    }
}
