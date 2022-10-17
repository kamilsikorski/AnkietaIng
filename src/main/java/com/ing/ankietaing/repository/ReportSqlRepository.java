package com.ing.ankietaing.repository;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportSqlRepository extends JpaRepository<QuestionnaireEntity,Long> {

    @Query("select distinct questions from QuestionnaireEntity questionnare join questionnare.questions questions join questions.closeAnswers answer " +
            "where questionnare.title = :title and questionnare.submitted=true" )
    List<QuestionEntity> listSelectedAnswersForQuestionnaire(@Param("title") String title);



}
