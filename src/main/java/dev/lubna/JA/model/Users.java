package dev.lubna.JA.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table( name = "users", indexes = {
        @Index(name = "username" ,columnList = "username")
})
@AttributeOverride(name = "id", column = @Column(name = "userid", updatable = false, nullable = false))
public class Users extends  BaseEntity{

//  Adding Users Security
    @NonNull
    @Column(name = "username" , nullable = false , unique = true)
    public  String username ;
    @NonNull
    public  String password ;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true)
    public List<JournalEntry> journalEntries = new ArrayList<>();

    public List<String> userRole;
}
