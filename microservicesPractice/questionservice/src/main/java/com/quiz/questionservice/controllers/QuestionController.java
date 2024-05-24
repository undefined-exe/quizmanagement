package com.quiz.questionservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.quiz.questionservice.entities.Question;
import com.quiz.questionservice.services.QuestionService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/question")
public class QuestionController {
 
    private QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<String> createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping
    public ResponseEntity<List<Question>> get(){
        return questionService.get();
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getById(@PathVariable Long questionId){
        return questionService.get(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> get(@PathVariable long quizId){
        return questionService.getQuestionsByQuiz(quizId);
    }
}
