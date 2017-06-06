package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.QuestionContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

  @GetMapping("/questions")
  public QuestionContainer getFiveRandomQuestions() {
    return new QuestionContainer();
  }
}
