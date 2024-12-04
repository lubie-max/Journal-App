package dev.lubna.JA.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
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

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    public List<JournalEntry> journalEntries = new ArrayList<>();
}
