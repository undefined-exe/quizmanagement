package com.quiz.questionservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.questionservice.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

    List<Question> findByQuizId(long quizId);
}