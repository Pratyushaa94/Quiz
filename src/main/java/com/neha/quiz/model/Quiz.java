package com.neha.quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(nullable = false)
    private int questionCount = 10;

    @Column(nullable = false)
    private int duration = 10;

    // Constructors
    public Quiz() {}

    public Quiz(String title, String description) {
        this.title = title;
        this.description = description;
        this.questionCount = 10;
        this.duration = 10;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuestionCount() { return questionCount; }
    public void setQuestionCount(int questionCount) { this.questionCount = questionCount; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}
