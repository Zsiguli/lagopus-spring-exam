package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.AnswerContainer;
import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionContainer;
import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionHandler {

  @Autowired
  QuestionRepository questionRepository;
  @Autowired
  QuestionContainer questionContainer;

  public QuestionContainer getFiveRandomQuestions() {
    List<Question> allTheQuestions = questionRepository.findAll();
    Collections.shuffle(allTheQuestions);
    List<Question> randomFiveQuestion = allTheQuestions.subList(0, 5);
    return questionContainer.setQuestions(randomFiveQuestion);
  }

  public Object answerChecker(AnswerContainer answers) {
    if (true) {
      return new RestTemplate().getForObject("https://springexamserver.herokuapp.com/projects/sabers", Object.class);
    } else {
      return new ArrayList<>();
    }
  }
}