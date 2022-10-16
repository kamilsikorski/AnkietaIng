package com.ing.ankietaing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="question")
public class QuestionEntity {

    public QuestionEntity() {
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
    @NotBlank(message = "Question must contain content")
    private String questionContent;

    @Getter
    @Setter
    private boolean multiSelection;

    @Getter
    @Setter
    private boolean openQuestion;

    @Getter
    @Setter
    private int minAnswer;

    @Getter
    @Setter
    private int maxAnswer;

    @Getter
    @Setter
    private String openAnswerContent;

    @Setter
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private QuestionnaireEntity questionnaireEntity;


    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER)
    private List<AnswerCloseEntity> closeAnswers;



}
