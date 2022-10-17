package com.ing.ankietaing.controller;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.service.AnswerOpenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerOpenController {

    private static final Logger logger = LoggerFactory.getLogger(AnswerOpenController.class);

    private final AnswerOpenService answerOpenService;

    public AnswerOpenController(AnswerOpenService answerOpenService) {
        this.answerOpenService = answerOpenService;
    }


    @PatchMapping("/updateAnswerOpen")
    ResponseEntity<?> updateAnswerClose(@RequestBody QuestionEntity questionEntity) {
        answerOpenService.fillOpenQuestion(questionEntity);
        return ResponseEntity.noContent().build();
    }

}
