package com.quiz.quizservice.entities;

import lombok.Data;

@Data
public class Question {
    private long questionId;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private long quizId;
}
