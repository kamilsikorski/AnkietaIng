package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.service.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionaireOwnerController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionaireOwnerController.class);


    private final QuestionnaireService questionnaireService;

    public QuestionaireOwnerController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }


    @PutMapping("/addQuestionnaireToOwner")
    ResponseEntity<?> addQuestionnaireToOwner(@Param("name") String name, @Param("surname") String surname, @RequestBody QuestionnaireEntity questionnaireEntity) {
        {
            QuestionaireOwnerEntity questionaireOwnerEntity = new QuestionaireOwnerEntity(name, surname);
            questionnaireService.addOwnerToQuestionnaire(questionaireOwnerEntity,questionnaireEntity);

            return ResponseEntity.noContent().build();
        }
    }



}
