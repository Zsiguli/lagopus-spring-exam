package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.AnswerContainer;
import com.greenfox.exam.spring.model.QuestionContainer;
import com.greenfox.exam.spring.repository.QuestionRepository;
import com.greenfox.exam.spring.service.QuestionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    return new RestTemplate().getForObject("https://springexamserver.herokuapp.com/projects/sabers", Object.class);
  }
}
