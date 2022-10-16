package com.ing.ankietaing.service;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    private final QuestionRepository questionRepository;

    private final QuestionnaireSqlRepository questionnaireSqlRepository;

    private final AnswerCloseRepository answerCloseRepository;

    private final QuestionaireOwnerRepository questionaireOwnerRepository;

    private final ReportSqlRepository reportSqlRepository;

    private final QuestionaireOwnerSqlRepository questionaireOwnerSqlRepository;


    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository, QuestionnaireSqlRepository questionnaireSqlRepository, AnswerCloseRepository answerCloseRepository, QuestionaireOwnerRepository questionaireOwnerRepository, ReportSqlRepository reportSqlRepository, QuestionaireOwnerSqlRepository questionaireOwnerSqlRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
        this.questionnaireSqlRepository = questionnaireSqlRepository;
        this.answerCloseRepository = answerCloseRepository;
        this.questionaireOwnerRepository = questionaireOwnerRepository;
        this.reportSqlRepository = reportSqlRepository;
        this.questionaireOwnerSqlRepository = questionaireOwnerSqlRepository;
    }

    public void addOwnerToQuestionnaire(QuestionaireOwnerEntity questionaireOwnerEntity, QuestionnaireEntity questionnaireEntity) {
        addFullQuestionnaire(questionnaireEntity);
        questionaireOwnerEntity.getQuestionnaireEntities().add(questionnaireEntity);
        questionaireOwnerRepository.save(questionaireOwnerEntity);
    }


    public void updateQuestionnaireByOwner(QuestionaireOwnerEntity questionaireOwnerEntity, QuestionnaireEntity questionnaireEntityUpdate) {

        QuestionnaireEntity questionnaireEntityFromDatabase = questionaireOwnerSqlRepository.findQuestionnaireForOwner(questionaireOwnerEntity.getName(),
                questionaireOwnerEntity.getSurename());



        questionnaireRepository.save(questionnaireEntityFromDatabase);


    }


    public void check() {
        reportSqlRepository.findMostPopularAnswer();
    }


    public ResponseEntity validateAllQuestionsFromQuestionnaire(List<QuestionnaireEntity> questionnaireEntity) {

        if (true) {
            return new ResponseEntity<>("jest zle", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.noContent().build();
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
