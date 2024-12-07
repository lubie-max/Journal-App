package dev.lubna.JA.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "journal")
@AttributeOverride(name = "id", column = @Column(name = "journal_id", updatable = false, nullable = false))
public class JournalEntry  extends  BaseEntity{


    @NonNull
    public String title ;
    public String content ;



    @ManyToOne
    @JoinColumn(name = "userid")
    private  User user ;



}
