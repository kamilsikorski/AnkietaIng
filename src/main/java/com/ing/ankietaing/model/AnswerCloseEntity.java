package com.ing.ankietaing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class AnswerCloseEntity {

    public AnswerCloseEntity() {
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
    private String answerContent;

    @Getter
    @Setter
    private boolean selected;

    @Setter
    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;


}
