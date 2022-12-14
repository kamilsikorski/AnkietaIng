package com.ing.ankietaing.repository;

import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireSqlRepository extends JpaRepository<QuestionnaireEntity,Long> {

    @Query("select distinct forms from QuestionnaireEntity forms join fetch forms.questions")
    List<QuestionnaireEntity> findAllNoLazy();
    @Override
    List<QuestionnaireEntity> findAll();

    @Query("select distinct forms from QuestionnaireEntity forms join fetch forms.questions where forms.title = :title")
    List<QuestionnaireEntity> findAllQuestionnaireByTitle(@Param("title") String title);



}
