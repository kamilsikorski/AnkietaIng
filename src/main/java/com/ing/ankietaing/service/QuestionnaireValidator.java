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

            if (selectedAnswers >= question.getMinAnswer() || selectedAnswers <= question.getMaxAnswer()) {
                throw new ValidationException(question.getQuestionContent() + " wrong number of answers" );
            }

            if(question.isOpenQuestion() && question.getOpenAnswerContent().isEmpty()){
                throw new ValidationException(question.getQuestionContent() + " no response for open question");
            }
        }

    }


}
