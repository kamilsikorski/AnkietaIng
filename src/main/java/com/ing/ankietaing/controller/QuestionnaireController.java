package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import com.ing.ankietaing.repository.QuestionRepository;
import com.ing.ankietaing.repository.QuestionnaireRepository;
import com.ing.ankietaing.repository.QuestionnaireSqlRepository;
import com.ing.ankietaing.service.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionnaireController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireRepository.class);


    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository, QuestionnaireSqlRepository questionnaireSqlRepository, QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PatchMapping("/submitQuestionnaire")
    ResponseEntity<?> submitQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity) {
        return questionnaireService.submitQuestionnaire(questionnaireEntity);
    }

    @PutMapping("/addquestionnaire")
    ResponseEntity<?> addQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity) {
        questionnaireService.addFullQuestionnaire(questionnaireEntity);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/allforms")
    public ResponseEntity<?> readAllQuestionnaires() {
        return ResponseEntity.ok(questionnaireService.readAllQuestionnaires());
    }

    @GetMapping("/allformsnolazy")
    public ResponseEntity<?> readAllQuestionnairesNoLazy() {
        return ResponseEntity.ok(questionnaireService.readAllQuestionnairesNoLazy());
    }
}
