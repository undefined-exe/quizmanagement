package com.quiz.quizservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizservice.entities.Quiz;
import com.quiz.quizservice.repositories.QuizRepository;
import com.quiz.quizservice.services.QuestionClient;
import com.quiz.quizservice.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public ResponseEntity<String> createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Quiz>> get() {
        List<Quiz> quizzes = quizRepository.findAll().stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
            return quiz;

        }).collect(Collectors.toList());
        
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Quiz> get(long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(new Quiz());
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quizId));

        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

}
