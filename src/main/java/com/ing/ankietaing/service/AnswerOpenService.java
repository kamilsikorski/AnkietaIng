package com.ing.ankietaing.service;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerOpenService {

    private final QuestionRepository questionRepository;

    public AnswerOpenService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void fillOpenQuestion(QuestionEntity questionEntity) {
        QuestionEntity questionPersisted = questionRepository.findById(questionEntity.getId()).get();
        questionPersisted.setOpenAnswerContent(questionEntity.getOpenAnswerContent());
        questionRepository.save(questionPersisted);
    }

}
