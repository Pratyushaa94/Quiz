package com.neha.quiz.controller;

import com.neha.quiz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/submit")
    public int submitScore(@RequestParam String username, @RequestParam Long quizId, @RequestBody Map<Long, String> userAnswers) {
        return scoreService.calculateScore(username, quizId, userAnswers);
    }
}
