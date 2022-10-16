package com.ing.ankietaing.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="owner")
public class QuestionaireOwnerEntity {

    public QuestionaireOwnerEntity() {
    }

    public QuestionaireOwnerEntity(String name, String surename) {
        this.name = name;
        this.surename = surename;
        this.questionnaireEntities = new ArrayList<>();
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
    private String name;

    @Getter
    @Setter
    private String surename;


    @Setter
    @Getter
    @OneToMany
    private List<QuestionnaireEntity> questionnaireEntities;


}
