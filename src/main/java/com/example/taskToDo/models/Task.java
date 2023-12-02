package com.example.taskToDo.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title", length = 100)
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "completed")
    boolean completed;

    @Column(name = "created")
    LocalDateTime created;

    @PrePersist
    protected void created() {
        completed = false;
        created = LocalDateTime.now();
    }
}
