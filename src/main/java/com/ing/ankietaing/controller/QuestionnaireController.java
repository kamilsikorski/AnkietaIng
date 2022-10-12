package com.ing.ankietaing.controller;


import com.ing.ankietaing.repository.QuestionnaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireRepository.class);

    private final QuestionnaireRepository questionnaireRepository;


    public QuestionnaireController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }


    @GetMapping("/allforms")
    public ResponseEntity<?> readAllQuestionnaires() {
        return ResponseEntity.ok(questionnaireRepository.findAll());
    }
}
