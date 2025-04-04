package com.neha.quiz.controller;

import com.neha.quiz.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/leaderboard/{quizId}")
    public ResponseEntity<List<Map<String, Object>>> getLeaderboard(@PathVariable Long quizId) {
        System.out.println("Received quizId: " + quizId);
        List<Map<String, Object>> leaderboard = leaderboardService.getLeaderboardByQuizId(quizId);
        return ResponseEntity.ok(leaderboard);
    }
}