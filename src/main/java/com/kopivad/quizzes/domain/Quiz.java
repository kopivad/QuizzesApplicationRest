package com.kopivad.quizzes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quizzes")
@EqualsAndHashCode(of = {"id"})
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "active", nullable = false)
    private boolean active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "creation_date", updatable = false, nullable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;
}
