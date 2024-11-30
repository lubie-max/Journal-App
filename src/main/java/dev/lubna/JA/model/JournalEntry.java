package dev.lubna.JA.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name = "journal")
public class JournalEntry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;
    public String title ;
    public String content ;

    @CreationTimestamp
    @Column(name = "created_at" , updatable = false)
    public LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
