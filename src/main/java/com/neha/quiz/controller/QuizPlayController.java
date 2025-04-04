package com.neha.quiz.controller;

import com.neha.quiz.model.Question;
import com.neha.quiz.service.QuestionService;
import com.neha.quiz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/play")
@CrossOrigin(origins = "*")
public class QuizPlayController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/{quizId}/questions/{questionNumber}")
    public Question getQuestion(@PathVariable Long quizId, @PathVariable int questionNumber) {
        Question question = questionService.getQuestion(quizId, questionNumber);

        if (question == null) {
            throw new RuntimeException("No question found for this quiz.");
        }


        System.out.println("Question: " + question.getQuestionText());
        System.out.println("Options: A=" + question.getOptionA() + " B=" + question.getOptionB() +
                " C=" + question.getOptionC() + " D=" + question.getOptionD());

        return question;
    }


    @PostMapping("/{quizId}/submit")
    public int submitQuiz(@PathVariable Long quizId, @RequestParam String username, @RequestBody Map<Long, String> userAnswers) {
        if (userAnswers == null || userAnswers.isEmpty()) {
            throw new RuntimeException("No answers submitted.");
        }

        return scoreService.calculateScore(username, quizId, userAnswers);
    }
}
