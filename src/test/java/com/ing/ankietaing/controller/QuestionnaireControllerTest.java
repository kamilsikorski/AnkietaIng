package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.repository.QuestionnaireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionnaireControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Test
    void returnAllQuestionnaires() {

    }

    @Test
    void checkReportForQuestionnaireForTwoUsers() {

        //1 creating questionnaires without answers
        QuestionnaireEntity questionnaire = prepareFullQuestionnairyEntity();
        questionnaire.setTitle("Ankieta test");

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Kamil");
        params.put("surname", "Sikorski");


        restTemplate.put("http://localhost:"+port+"/addQuestionnaireToOwner/?name={name}&surname={surname}",questionnaire,params);
        QuestionnaireEntity[] result = restTemplate.getForObject("http://localhost:"+port+"/allforms",QuestionnaireEntity[].class);


////        2 filling the answers
//        AnswerCloseEntity answerForFirstQuestion = result[0].getQuestions().get(0).getCloseAnswers().get(0);
//        answerForFirstQuestion.setSelected(true);
//
//        restTemplate.patchForObject("http://localhost:"+port+"/updateAnswerClose", answerForFirstQuestion,AnswerCloseEntity.class);
        //todo dokonczyc end to end test


    }



    private QuestionnaireEntity prepareFullQuestionnairyEntity(){

        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();

        QuestionEntity questionEntity1 = QuestionEntity.builder().minAnswer(1).maxAnswer(1).questionContent("Jaka jest Twoja ulubiona pora roku?")
                        .closeAnswers(Arrays.asList(AnswerCloseEntity.builder().answerContent("Wiosna").build(),
                                AnswerCloseEntity.builder().answerContent("Lato").build(),
                                AnswerCloseEntity.builder().answerContent("Jesień").build(),
                                AnswerCloseEntity.builder().answerContent("Zima").build())).build();

        QuestionEntity questionEntity2 = QuestionEntity.builder().minAnswer(1).maxAnswer(4).multiSelection(true).questionContent("Jaka jest Twoja ulubiona pogoda")
                .closeAnswers(Arrays.asList(AnswerCloseEntity.builder().answerContent("Słoneczna").build(),
                        AnswerCloseEntity.builder().answerContent("Deszczowa").build(),
                        AnswerCloseEntity.builder().answerContent("Mglista").build(),
                        AnswerCloseEntity.builder().answerContent("Upalna").build())).build();


        QuestionEntity questionEntity3 = QuestionEntity.builder().openQuestion(true).questionContent("Jakie jest Twoje ulubione danie?").build();


        questionnaireEntity.setQuestions(Arrays.asList(questionEntity1,questionEntity2,questionEntity3));



        return questionnaireEntity;

    }





}
