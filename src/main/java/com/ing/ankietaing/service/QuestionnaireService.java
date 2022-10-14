package com.ing.ankietaing.service;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.repository.AnswerCloseRepository;
import com.ing.ankietaing.repository.QuestionRepository;
import com.ing.ankietaing.repository.QuestionnaireRepository;
import com.ing.ankietaing.repository.QuestionnaireSqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    private final QuestionRepository questionRepository;

    private final QuestionnaireSqlRepository questionnaireSqlRepository;

    private final AnswerCloseRepository answerCloseRepository;


    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository, QuestionnaireSqlRepository questionnaireSqlRepository, AnswerCloseRepository answerCloseRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
        this.questionnaireSqlRepository = questionnaireSqlRepository;
        this.answerCloseRepository = answerCloseRepository;
    }

    public void addFullQuestionnaire(QuestionnaireEntity questionnaireEntity) {

        if (questionnaireEntity.getQuestions() != null) {

            for (QuestionEntity questionEntity : questionnaireEntity.getQuestions()) {
                if (questionEntity.getCloseAnswers() != null) {
                    answerCloseRepository.saveAll(questionEntity.getCloseAnswers());
                }
            }

            questionRepository.saveAll(questionnaireEntity.getQuestions());
        }
        questionnaireRepository.save(questionnaireEntity);
    }

    public List<QuestionnaireEntity> readAllQuestionnairesNoLazy() {
        return questionnaireSqlRepository.findAllNoLazy();
    }

    public List<QuestionnaireEntity> readAllQuestionnaires() {
        return questionnaireSqlRepository.findAll();
    }

}
