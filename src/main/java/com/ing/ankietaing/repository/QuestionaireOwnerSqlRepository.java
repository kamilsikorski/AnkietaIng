package com.ing.ankietaing.repository;

import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionaireOwnerSqlRepository extends JpaRepository<QuestionaireOwnerEntity, Long> {


    @Query("select distinct questionnaire from QuestionaireOwnerEntity owner join owner.questionnaireEntities questionnaire where " +
            "owner.name =:name and owner.surename = :surename")
    QuestionnaireEntity findQuestionnaireForOwner(@Param("name") String name, @Param("surename") String surename);




}
