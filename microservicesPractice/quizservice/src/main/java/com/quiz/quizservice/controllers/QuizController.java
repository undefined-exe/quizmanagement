package com.quiz.quizservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizservice.entities.Quiz;
import com.quiz.quizservice.services.QuizService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/quiz")
public class QuizController {
 
    private QuizService quizService;
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> get(){
        return quizService.get();
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> get(long quizId){
        return quizService.get(quizId);
    }
}
