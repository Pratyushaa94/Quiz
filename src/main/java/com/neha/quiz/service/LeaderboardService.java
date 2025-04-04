package com.neha.quiz.service;

import com.neha.quiz.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaderboardService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getLeaderboardByQuizId(Long quizId) {
        System.out.println("Fetching leaderboard for quiz_id: " + quizId);
        String sql = "SELECT username, score FROM scores WHERE quiz_id = ? ORDER BY score DESC";
        return jdbcTemplate.queryForList(sql, quizId);
    }
}