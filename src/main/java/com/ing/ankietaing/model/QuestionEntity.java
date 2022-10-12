package com.ing.ankietaing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="questionnaire")
public class QuestionEntity {

    public QuestionEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "question_content")
    @NotBlank(message = "Question must contain content")
    private String questionContent;

    @Getter
    @Setter
    @Column(name = "multi_selection")
    private boolean multiSelection;

    @Getter
    @Setter
    @Column(name = "open_question")
    private boolean openQuestion;

    @Getter
    @Setter
    @Column(name = "min_answer")
    private int minAnswer;

    @Getter
    @Setter
    @Column(name = "max_answer")
    private int maxAnswer;

}
