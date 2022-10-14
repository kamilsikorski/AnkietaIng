package com.ing.ankietaing.controller;


import com.ing.ankietaing.repository.AnswerCloseRepository;
import com.ing.ankietaing.repository.QuestionRepository;
import com.ing.ankietaing.repository.QuestionnaireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionnaireControllerTest {

    @LocalServerPort
    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Autowired
//    private QuestionnaireController questionnaireController;
//
//    @Autowired
//    private QuestionnaireRepository questionnaireRepository;
//
//    @Autowired
//    private AnswerCloseRepository answerCloseRepository;
//
//    @Autowired
//    private QuestionRepository questionRepository;
//
//    @Test
//    void httpGetReturnAllQuestionnaries() {
//        ankieta
//        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
//        questionnaireEntity.setTitle("O nazywaniu sie");
//
//        //odpowiedzi
//        List<AnswerCloseEntity> answerCloseEntityList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            AnswerCloseEntity answerCloseEntity = new AnswerCloseEntity();
//            answerCloseEntity.setAnswerContent("Kamil" + i);
//            answerCloseEntityList.add(answerCloseEntity);
//        }
//        List<AnswerCloseEntity> persistanceAnswer =  answerCloseRepository.saveAll(answerCloseEntityList);
//
//
//        //pytania
//        QuestionEntity questionEntity = new QuestionEntity();
//        questionEntity.setQuestionContent("Jak masz na imie?");
//        questionEntity.setCloseAnswers(persistanceAnswer);
//        QuestionEntity persistanceEntity = questionRepository.save(questionEntity);
//
//
//        questionnaireEntity.setQuestions(Arrays.asList(persistanceEntity));
//
//
//
//        questionnaireRepository.save(questionnaireEntity);
//
//        List list =  new ArrayList<>((Collection) questionnaireController.readAllQuestionnairesNoLazy().getBody());
//
//        int k = 0;
//
//    }

}
