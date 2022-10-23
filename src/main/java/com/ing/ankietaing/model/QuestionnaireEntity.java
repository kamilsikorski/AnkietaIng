package com.ing.ankietaing.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="questionnaire")
public class QuestionnaireEntity {

    public QuestionnaireEntity() {
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
    @NotBlank(message = "Title can't be empty")
    private String title;

    @Getter
    @Setter
    private boolean submitted;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    private List<QuestionEntity> questions;

    @Setter
    @ManyToOne
    @Getter
    @JoinColumn(name = "owner_id")
    private QuestionaireOwnerEntity questionaireOwnerEntity;


}
