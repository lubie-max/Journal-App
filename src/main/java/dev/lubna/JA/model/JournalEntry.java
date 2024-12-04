package dev.lubna.JA.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name = "journal")
public class JournalEntry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;

    @NonNull
    public String title ;
    public String content ;

    @CreationTimestamp
    @Column(name = "created_at" , updatable = false)
    public LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "userid" , nullable = false)
    private  User user ;


}
