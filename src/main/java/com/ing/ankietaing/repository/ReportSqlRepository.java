package com.ing.ankietaing.repository;

import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportSqlRepository extends JpaRepository<QuestionnaireEntity,Long> {

    @Query("select distinct close from QuestionaireOwnerEntity owner join  owner.questionnaireEntities quesionnaire join  quesionnaire.questions questions join questions.closeAnswers close where owner.name='Kamil' " )
    List<AnswerCloseEntity> findMostPopularAnswer();

}
