package com.quiz.quizservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quizservice.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
