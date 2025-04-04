package com.neha.quiz.service;

import com.neha.quiz.model.Question;
import com.neha.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question getQuestion(Long quizId, int questionNumber) {
        List<Question> questions = questionRepository.findByQuizId(quizId);

        if (questions == null || questions.isEmpty()) {
            System.out.println("No questions found for quiz ID: " + quizId);
            return null;
        }

        if (questionNumber < 1 || questionNumber > questions.size()) {
            System.out.println("Invalid question number: " + questionNumber);
            return null;
        }

        Question question = questions.get(questionNumber - 1);


        if (question.getOptionA() == null) question.setOptionA("Option A");
        if (question.getOptionB() == null) question.setOptionB("Option B");
        if (question.getOptionC() == null) question.setOptionC("Option C");
        if (question.getOptionD() == null) question.setOptionD("Option D");

        return question;
    }
}
