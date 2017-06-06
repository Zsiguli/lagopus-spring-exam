package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.AnswerContainer;
import com.greenfox.exam.spring.model.QuestionContainer;
import com.greenfox.exam.spring.service.QuestionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class QuestionController {

  @Autowired
  QuestionHandler questionHandler;

  @GetMapping("/questions")
  public QuestionContainer returnFiveRandomQuestions() {
    return questionHandler.getFiveRandomQuestions();
  }

  @PostMapping("/answers")
  public Object receiveAnswers(@RequestBody AnswerContainer answerContainer) {
    return questionHandler.answerChecker(answerContainer);
  }
}
