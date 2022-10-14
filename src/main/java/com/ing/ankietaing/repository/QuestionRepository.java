package com.ing.ankietaing.repository;


import com.ing.ankietaing.model.QuestionEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {


    @RestResource(path = "findCloseQuestions", rel="findCloseQuestions")
    List<QuestionEntity> findByMultiSelectionIsFalseAndOpenQuestionIsFalse();

    @Query(nativeQuery= true, value = "select count(*) > 0 from question where id=:id")
    @Override
    boolean existsById(@Param("id")Long id);

    boolean existsByQuestionnaireEntityTitle(String title);

    boolean existsByQuestionnaireEntity_Id(Long id);
}
