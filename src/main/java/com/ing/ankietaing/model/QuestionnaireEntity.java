package com.ing.ankietaing.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="questionnaire")
public class QuestionnaireEntity {

    public QuestionnaireEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Title can't be empty")
    private String title;


}
