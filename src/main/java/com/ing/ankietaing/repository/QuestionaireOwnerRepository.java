package com.ing.ankietaing.repository;

import com.ing.ankietaing.model.QuestionaireOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionaireOwnerRepository extends JpaRepository<QuestionaireOwnerEntity, Long> {
}
