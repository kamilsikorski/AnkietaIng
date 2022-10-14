package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.repository.QuestionRepository;
import com.ing.ankietaing.repository.QuestionnaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class QuestionController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/allquestions")
    public ResponseEntity<?> readAllQuestions() {
        logger.warn("Exposing all questions");
        return ResponseEntity.ok(questionRepository.findAll());
    }

    @PutMapping("/question/{id}")
    ResponseEntity<?> updateQuestion(@PathVariable long id, @RequestBody QuestionEntity toUpdate) {
        if(!questionRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        questionRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/addquestion")
    ResponseEntity<?> addQuestion(@RequestBody QuestionEntity questionEntity) {
        questionRepository.save(questionEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/questionIfExists/{id}")
    ResponseEntity<?> questionIfExists(@PathVariable long id) {
       return ResponseEntity.ok(questionRepository.existsById(id));
    }

}
