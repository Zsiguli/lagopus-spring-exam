package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.QuestionContainer;
import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

  @Autowired
  QuestionRepository questionRepository;

  @GetMapping("/questions")
  public QuestionContainer getFiveRandomQuestions() {
    return new QuestionContainer(questionRepository.findAll());
  }
}
