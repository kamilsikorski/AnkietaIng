package com.ing.ankietaing.service;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class QuestionnaireServiceTest {


    QuestionnaireService questionnaireService;

    @Mock
    QuestionnaireRepository questionnaireRepository;

    @Mock
    QuestionRepository questionRepository;

    @Mock
    QuestionnaireSqlRepository questionnaireSqlRepository;

    @Mock
    AnswerCloseRepository answerCloseRepository;

    @Mock
    QuestionaireOwnerRepository questionaireOwnerRepository;

    @Mock
    ReportSqlRepository reportSqlRepository;

    @Mock
    QuestionaireOwnerSqlRepository questionaireOwnerSqlRepository;

    @Mock
    QuestionnaireValidator questionnaireValidator;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        questionnaireService = new QuestionnaireService(questionnaireRepository, questionRepository, questionnaireSqlRepository, answerCloseRepository,
                questionaireOwnerRepository, reportSqlRepository, questionaireOwnerSqlRepository, questionnaireValidator);
    }

    @Test
    @DisplayName("should throw IllegalStateException when questionnaire is without questions")
    void addOwnerToQuestionnaireWithoutQuestionsThrowsException() {

        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        assertThrows(IllegalStateException.class, () -> questionnaireService.addFullQuestionnaire(questionnaireEntity), "Qustionnaire must contain questions");

    }

    @Test
    @DisplayName("Correct adding new questionnaire")
    void addOwnerToQuestionnaire() {
        //given
        when(answerCloseRepository.saveAll(any())).thenReturn(new ArrayList<>());

        QuestionnaireEntity questionnaire = prepareFullQuestionnaireEtity();

        //when
        questionnaireService.addFullQuestionnaire(questionnaire);

        //then
        verify(answerCloseRepository, atLeast(1)).saveAll(any());
        verify(questionRepository, atLeast(1)).saveAll(any());
        verify(questionnaireRepository, atLeast(1)).save(any());
    }


    private QuestionnaireEntity prepareFullQuestionnaireEtity() {

        QuestionnaireEntity questionnaire = new QuestionnaireEntity();
        QuestionEntity questionEntity = new QuestionEntity();
        AnswerCloseEntity answerCloseEntity = new AnswerCloseEntity();

        questionEntity.setCloseAnswers(Arrays.asList(answerCloseEntity));
        questionnaire.setQuestions(Arrays.asList(questionEntity));

        return questionnaire;
    }

}