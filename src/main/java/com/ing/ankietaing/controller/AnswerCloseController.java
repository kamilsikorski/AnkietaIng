package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.service.AnswerCloseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerCloseController {

    private static final Logger logger = LoggerFactory.getLogger(AnswerCloseController.class);

    private final AnswerCloseService answerCloseService;

    public AnswerCloseController(AnswerCloseService answerCloseService) {
        this.answerCloseService = answerCloseService;
    }


    @PatchMapping("/updateAnswerClose")
    ResponseEntity<?> updateAnswerClose(@RequestBody AnswerCloseEntity answerCloseEntity) {
        answerCloseService.updateCloseAnswer(answerCloseEntity);

        return ResponseEntity.noContent().build();
    }

}
