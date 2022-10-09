package com.ing.ankietaing.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "ankieta", catalog = "")
public class QuestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "question_content")
    private String questionContent;
    @Basic
    @Column(name = "multi_selection")
    private Byte multiSelection;
    @Basic
    @Column(name = "open_question")
    private byte openQuestion;
    @Basic
    @Column(name = "min_answer")
    private Integer minAnswer;
    @Basic
    @Column(name = "max_answer")
    private Integer maxAnswer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return id == that.id && openQuestion == that.openQuestion && Objects.equals(questionContent, that.questionContent) && Objects.equals(multiSelection, that.multiSelection) && Objects.equals(minAnswer, that.minAnswer) && Objects.equals(maxAnswer, that.maxAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionContent, multiSelection, openQuestion, minAnswer, maxAnswer);
    }
}
