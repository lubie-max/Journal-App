package dev.lubna.JA.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "journal")
@AttributeOverride(name = "id", column = @Column(name = "journal_id", updatable = false, nullable = false))
public class JournalEntry  extends  BaseEntity{


    @NonNull
    public String title ;
    public String content ;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userid")
    private Users user;



}
