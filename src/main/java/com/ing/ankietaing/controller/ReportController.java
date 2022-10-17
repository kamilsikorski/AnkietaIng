package com.ing.ankietaing.controller;


import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reportAnswerForQuestionnaire")
    public ResponseEntity<?> reportAnswerForQuestionnaire(@Param("title") String title) {

        List<String> reportsRow = reportService.createReportForQuestionnaire(title);
        return new ResponseEntity<>(reportsRow,HttpStatus.OK);

    }
}
