package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.AnswerContainer;
import com.greenfox.exam.spring.model.QuestionContainer;
import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuestionController {

  @Autowired
  QuestionRepository questionRepository;
  @Autowired
  QuestionContainer questionContainer;

  @GetMapping("/questions")
  public QuestionContainer getFiveRandomQuestions() {
    return questionContainer.setQuestions(questionRepository.findAll());
  }

  @PostMapping("/answers")
  public Object receiveAnswers(@RequestBody AnswerContainer answerContainer) {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject("https://springexamserver.herokuapp.com/projects/sabers", Object.class);
  }
}
