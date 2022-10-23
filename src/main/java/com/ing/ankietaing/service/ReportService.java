package com.ing.ankietaing.service;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {


    private final ReportSqlRepository reportSqlRepository;

    private final QuestionnaireSqlRepository questionnaireSqlRepository;

    public ReportService(ReportSqlRepository reportSqlRepository, QuestionnaireRepository questionnaireRepository, QuestionnaireSqlRepository questionnaireSqlRepository) {
        this.reportSqlRepository = reportSqlRepository;
        this.questionnaireSqlRepository = questionnaireSqlRepository;
    }


    public List<String> createReportForQuestionnaire(String title) {

        List<String> reportsRow = new ArrayList<>();

        Map<String, List<AnswerCloseEntity>> reportAnswerMap = new HashMap<>();
        List<QuestionEntity> allSubmittedQuestions = reportSqlRepository.listSelectedAnswersForQuestionnaire(title);
        Set<String> questionNames = allSubmittedQuestions.stream().map(questionEntity -> questionEntity.getQuestionContent()).collect(Collectors.toSet());

        for (String questionName : questionNames) {
            reportAnswerMap.put(questionName, new ArrayList<>());
        }


        for (String questionName : questionNames) {
            for (QuestionEntity questionEntity : allSubmittedQuestions) {
                if (questionName.equals(questionEntity.getQuestionContent())) {
                    reportAnswerMap.get(questionName).addAll(questionEntity.getCloseAnswers());
                }
            }
        }


        for (Map.Entry<String, List<AnswerCloseEntity>> set :
                reportAnswerMap.entrySet()) {


            List<AnswerCloseEntity> resultListForQuestion = set.getValue();

            List<AnswerCloseEntity> selectedAnswersList = resultListForQuestion.stream().
                    filter(answerCloseEntity -> answerCloseEntity.isSelected()).collect(Collectors.toList());

            Set<String> answersNameList = resultListForQuestion.stream().map(answerCloseEntity -> answerCloseEntity.getAnswerContent()).collect(Collectors.toSet());


            for (String answerName : answersNameList) {
                double selectedValueCounter = selectedAnswersList.stream().filter(selectedAnswer -> answerName.equals(selectedAnswer.getAnswerContent())).count();
                reportsRow.add("Pytanie: " + set.getKey() + " Odpowiedz: " + answerName + " " + ((selectedValueCounter/selectedAnswersList.size())*100)+"%");
            }

        }


        return reportsRow;

    }

}
