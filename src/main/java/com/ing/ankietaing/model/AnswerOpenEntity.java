package com.ing.ankietaing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class AnswerOpenEntity {

    public AnswerOpenEntity() {
    }

    @Embedded
    private Audit audit = new Audit();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Answer must contain content")
    private String openAnswerContent;

    @Setter
    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;


}
