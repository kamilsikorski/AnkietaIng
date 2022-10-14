//package com.ing.ankietaing.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name="user")
//public class UserEntity {
//
//    public UserEntity() {
//    }
//
//    @Embedded
//    private Audit audit = new Audit();
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Getter
//    @Setter
//    private Long id;
//
//    @Getter
//    @Setter
//    private String name;
//
//    @Getter
//    @Setter
//    private String surname;
//
//    @Getter
//    @Setter
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<QuestionnaireEntity> questionnaires;
//
//
//}
