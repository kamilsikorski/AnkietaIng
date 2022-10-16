package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.service.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.support.RepositoryConstraintViolationExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
public class QuestionaireOwnerController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionaireOwnerController.class);


    private final QuestionnaireService questionnaireService;

    public QuestionaireOwnerController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/check")
    public ResponseEntity<?> check() {
        logger.warn("Exposing all questions");
        questionnaireService.check();
        return ResponseEntity.ok().build();
    }



    //no validation first creation
    @PutMapping("/addQuestionnaireToOwner")
    ResponseEntity<?> addQuestionnaireToOwner(@Param("name") String name, @Param("surname") String surname, @RequestBody QuestionnaireEntity questionnaireEntity) {
        {
            QuestionaireOwnerEntity questionaireOwnerEntity = new QuestionaireOwnerEntity(name, surname);

            questionnaireService.addOwnerToQuestionnaire(questionaireOwnerEntity,questionnaireEntity);

            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/updateQuestionnaireByOwner")
    ResponseEntity<?> updateQuestionnaireByOwner(@Param("name") String name, @Param("surname") String surname, @RequestBody QuestionnaireEntity questionnaireEntity) {
        {
            QuestionaireOwnerEntity questionaireOwnerEntity = new QuestionaireOwnerEntity(name, surname);

            ResponseEntity responseEntityResult = questionnaireService.validateQuestionnaireQuery(questionnaireEntity);
            questionnaireService.addOwnerToQuestionnaire(questionaireOwnerEntity,questionnaireEntity);

            return responseEntityResult;
        }
    }

}
