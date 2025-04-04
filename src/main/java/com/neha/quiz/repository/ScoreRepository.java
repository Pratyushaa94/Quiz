package com.neha.quiz.repository;

import com.neha.quiz.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    List<Score> findByQuizIdOrderByScoreDesc(Long quizId);
}
