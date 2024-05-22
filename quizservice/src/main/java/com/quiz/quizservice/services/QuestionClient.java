package com.quiz.quizservice.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.quizservice.entities.Question;

@FeignClient("questionservice")
public interface QuestionClient {
    
    @GetMapping("question/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
