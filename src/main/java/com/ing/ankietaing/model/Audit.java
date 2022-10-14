package com.ing.ankietaing.model;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
public class Audit {

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @PrePersist
    void prePersist(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    void preMerge() {
        updatedDate = LocalDateTime.now();
    }

}
