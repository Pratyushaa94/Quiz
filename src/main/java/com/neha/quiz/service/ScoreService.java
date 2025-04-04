package com.neha.quiz.service;

import com.neha.quiz.model.Question;
import com.neha.quiz.model.Score;
import com.neha.quiz.repository.QuestionRepository;
import com.neha.quiz.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ScoreService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public int calculateScore(String username, Long quizId, Map<Long, String> userAnswers) {
        System.out.println("Received username: " + username);

        if (username == null || username.isEmpty()) {
            System.out.println("Error: Username is missing!");
            return 0;
        }

        List<Question> questions = questionRepository.findByQuizId(quizId);
        int score = 0;

        for (Question question : questions) {
            String correctOption = question.getCorrectOption();
            String userAnswer = userAnswers.get(question.getId());

            if (correctOption != null && userAnswer != null) {
                if (correctOption.trim().equalsIgnoreCase(userAnswer.trim())) {
                    score += 2;
                }
            }
        }

        System.out.println("Final Score: " + score);


        Score scoreEntry = new Score(username, quizId, score);
        scoreRepository.save(scoreEntry);

        return score;
    }
}