package dev.lubna.JA.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(updatable = false, nullable = false, columnDefinition = "UUID")
//    @Id
//    private UUID uuid ;

    @Id
    @Column(updatable = false, nullable = false, columnDefinition = "UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public UUID id;

    @Column(nullable = false ,updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private  LocalDateTime updatedAt;


    @PrePersist
    protected  void  onCreate(){
        this.createdAt = LocalDateTime.now();
    }



}
