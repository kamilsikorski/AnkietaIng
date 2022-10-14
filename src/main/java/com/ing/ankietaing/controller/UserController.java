//package com.ing.ankietaing.controller;
//
//
//import com.ing.ankietaing.model.QuestionnaireEntity;
//import com.ing.ankietaing.model.UserEntity;
//import com.ing.ankietaing.repository.QuestionnaireRepository;
//import com.ing.ankietaing.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class UserController {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    private final QuestionnaireRepository questionnaireRepository;
//    private final UserRepository userRepository;
//
//
//    public UserController(QuestionnaireRepository questionnaireRepository, UserRepository userRepository) {
//        this.questionnaireRepository = questionnaireRepository;
//        this.userRepository = userRepository;
//    }
//
//
//    @PutMapping("/addQuestionnaireToUser")
//    ResponseEntity<?> addQuestionnaireToUser(@Param("name")String name, @Param("surname")String surname, @RequestBody QuestionnaireEntity questionnaireEntity) {
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setName(name);
//        userEntity.setSurname(surname);
//        questionnaireRepository.save(questionnaireEntity);
//        userEntity.getQuestionnaires().add(questionnaireEntity);
//
//        userRepository.save(userEntity);
//        return ResponseEntity.noContent().build();
//    }
//}
