package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.Questions;
import com.peter.smartmedicalserver.mapper.QuestionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsMapper questionsMapper;


    public List<Questions> getAllQuestions() {
        return questionsMapper.getAllQuestions();
    }

    @Transactional
    public void deleteById(int id) {
        // get the question before deleting it
        Questions questions = questionsMapper.getById(id);
        // get the answer before deleting it
        Questions answer = questionsMapper.getAnswersByThreadIdAndQuestionId(questions.getThreadId(), questions.getId());
        questionsMapper.deleteById(id);
        if (answer != null)
            questionsMapper.deleteById(answer.getId());
    }

    @Transactional
    public Questions update(int id, Questions questions) {
        questionsMapper.update(id, questions);
        return questionsMapper.getById(id);
    }


}
