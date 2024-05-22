package com.quiz.quizservice.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.quizservice.entities.Quiz;

public interface QuizService {
    public ResponseEntity<String> createQuiz(Quiz quiz);

    public ResponseEntity<List<Quiz>> get();

    public ResponseEntity<Quiz> get(long quizId);
}
