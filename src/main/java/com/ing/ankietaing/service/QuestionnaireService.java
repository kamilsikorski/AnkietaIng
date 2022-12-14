package com.ing.ankietaing.service;

import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionnaireService {



    private final QuestionnaireRepository questionnaireRepository;

    private final QuestionRepository questionRepository;

    private final QuestionnaireSqlRepository questionnaireSqlRepository;

    private final AnswerCloseRepository answerCloseRepository;

    private final QuestionaireOwnerRepository questionaireOwnerRepository;

    private final ReportSqlRepository reportSqlRepository;

    private final QuestionaireOwnerSqlRepository questionaireOwnerSqlRepository;

    private final QuestionnaireValidator questionnaireValidator;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository, QuestionnaireSqlRepository questionnaireSqlRepository, AnswerCloseRepository answerCloseRepository, QuestionaireOwnerRepository questionaireOwnerRepository, ReportSqlRepository reportSqlRepository, QuestionaireOwnerSqlRepository questionaireOwnerSqlRepository, QuestionnaireValidator questionnaireValidator) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
        this.questionnaireSqlRepository = questionnaireSqlRepository;
        this.answerCloseRepository = answerCloseRepository;
        this.questionaireOwnerRepository = questionaireOwnerRepository;
        this.reportSqlRepository = reportSqlRepository;
        this.questionaireOwnerSqlRepository = questionaireOwnerSqlRepository;
        this.questionnaireValidator = questionnaireValidator;
    }

    public void addOwnerToQuestionnaire(QuestionaireOwnerEntity questionaireOwnerEntity, QuestionnaireEntity questionnaireEntity) {
        addFullQuestionnaire(questionnaireEntity);
        questionaireOwnerEntity.getQuestionnaireEntities().add(questionnaireEntity);
        questionaireOwnerRepository.save(questionaireOwnerEntity);
    }


    public ResponseEntity<?> submitQuestionnaire(QuestionnaireEntity questionnaireEntity) {

        QuestionnaireEntity persistedQuestionnaire = questionnaireRepository.findById(questionnaireEntity.getId()).get();
        ResponseEntity submitResult = validateAllQuestionsFromQuestionnaire(persistedQuestionnaire);
        if (submitResult.getStatusCode().equals(HttpStatus.ACCEPTED)) {
            persistedQuestionnaire.setSubmitted(true);
            questionnaireRepository.save(persistedQuestionnaire);
        }

        return submitResult;
    }


    public void updateQuestionnaireByOwner(QuestionaireOwnerEntity questionaireOwnerEntity, QuestionnaireEntity questionnaireEntityUpdate) {

        QuestionnaireEntity questionnaireEntityFromDatabase = questionaireOwnerSqlRepository.findQuestionnaireForOwner(questionaireOwnerEntity.getName(),
                questionaireOwnerEntity.getSurename());

        questionnaireRepository.save(questionnaireEntityFromDatabase);
    }


//    public void check() {
//        reportSqlRepository.findMostPopularAnswer();
//    }


    private ResponseEntity validateAllQuestionsFromQuestionnaire(QuestionnaireEntity questionnaireEntity) {

        questionnaireValidator.allAnswersFilled(questionnaireEntity);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }



    public void addFullQuestionnaire(QuestionnaireEntity questionnaireEntity) {

        if(CollectionUtils.isEmpty(questionnaireEntity.getQuestions())){
            throw new IllegalStateException("Qustionnaire must contain questions");
        }

        questionnaireEntity.getQuestions().stream().filter(questionEntity -> null != questionEntity.getCloseAnswers())
                .forEach(questionEntity -> {
                    answerCloseRepository.saveAll(questionEntity.getCloseAnswers());
                });

        questionRepository.saveAll(questionnaireEntity.getQuestions());
        questionnaireRepository.save(questionnaireEntity);

    }

    public List<QuestionnaireEntity> readAllQuestionnairesNoLazy() {
        return questionnaireSqlRepository.findAllNoLazy();
    }

    public List<QuestionnaireEntity> readAllQuestionnaires() {
        return questionnaireSqlRepository.findAll();
    }

}
