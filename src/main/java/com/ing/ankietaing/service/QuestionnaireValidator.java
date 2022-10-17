package com.ing.ankietaing.service;

import antlr.StringUtils;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.stream.Collectors;

@Component
public class QuestionnaireValidator {

    public void allAnswersFilled(QuestionnaireEntity questionnaireEntity) {

        for (QuestionEntity question : questionnaireEntity.getQuestions()) {
            int selectedAnswers = question.getCloseAnswers().stream()
                    .filter(answerClose -> answerClose.isSelected()).collect(Collectors.toList()).size();

            if (selectedAnswers < question.getMinAnswer()) {
                throw new ValidationException(question.getQuestionContent() + " to small number of answers" );
            }

            if (selectedAnswers > question.getMaxAnswer()) {
                throw new ValidationException(question.getQuestionContent() + " to many answers" );
            }

            if(question.isOpenQuestion() && null == question.getOpenAnswerContent()){
                throw new ValidationException(question.getQuestionContent() + " no response for open question");
            }
        }

    }


}
