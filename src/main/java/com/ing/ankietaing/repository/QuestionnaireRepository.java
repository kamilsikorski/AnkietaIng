package com.ing.ankietaing.repository;


import com.ing.ankietaing.model.QuestionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<QuestionnaireEntity,Long> {

}
