package com.springproject.SpringTriviaApp.repository;

import com.springproject.SpringTriviaApp.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
}
