package dev.lubna.JA.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Indexed;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table( name = "users", indexes = {
        @Index(name = "username" ,columnList = "username")
})
public class User {

    @Id
    @GeneratedValue()
    @Column(columnDefinition = "UUID")
    public UUID userid;

    @Column(name = "username" , nullable = false , unique = true)
    public  String username ;
    @NonNull
    public  String password ;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    public List<JournalEntry> journalEntries;
}
