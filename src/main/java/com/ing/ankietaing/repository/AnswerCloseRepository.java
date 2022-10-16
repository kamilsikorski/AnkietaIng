package com.ing.ankietaing.repository;


import com.ing.ankietaing.model.AnswerCloseEntity;
import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerCloseRepository extends JpaRepository<AnswerCloseEntity,Long> {

}
