package com.ing.ankietaing.service;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AnswerCloseService {

    private final AnswerCloseRepository answerCloseRepository;

    public AnswerCloseService(AnswerCloseRepository answerCloseRepository) {
        this.answerCloseRepository = answerCloseRepository;
    }

    public void updateCloseAnswer(AnswerCloseEntity answerCloseEntity) {

        answerCloseRepository.findById(answerCloseEntity.getId())
                .ifPresent(acEntity -> {
                    acEntity.setSelected(answerCloseEntity.isSelected());
                    answerCloseRepository.save(acEntity);
                });


    }

}
