package com.quiz.questionservice.services.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.questionservice.entities.Question;
import com.quiz.questionservice.repositories.QuestionRepository;
import com.quiz.questionservice.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public ResponseEntity<String> createQuestion(Question question) {
        questionRepository.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Question>> get() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Question> get(long questionId) {
        return new ResponseEntity<>(questionRepository.findById(questionId).orElse(new Question()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByQuiz(long quizId) {
        return new ResponseEntity<>(questionRepository.findByQuizId(quizId), HttpStatus.OK);
    }
}
