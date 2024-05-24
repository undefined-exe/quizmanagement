package com.quiz.questionservice.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.questionservice.entities.Question;

public interface QuestionService {
    public ResponseEntity<String> createQuestion(Question question);

    public ResponseEntity<List<Question>> get();

    public ResponseEntity<Question> get(long questionId);

    public ResponseEntity<List<Question>> getQuestionsByQuiz(long quizId);
}
