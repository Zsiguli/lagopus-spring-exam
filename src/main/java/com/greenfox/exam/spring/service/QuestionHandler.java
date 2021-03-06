package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.Answer;
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

  public Object answerChecker(AnswerContainer answerContainer) {
    if (isEveryAnswerRight(answerContainer)) {
      return new RestTemplate().getForObject("https://springexamserver.herokuapp.com/projects/sabers", Object.class);
    } else {
      AnswerContainer noAnswers = new AnswerContainer();
      noAnswers.setAnswers(new ArrayList<>());
      noAnswers.setId(0);
      return noAnswers;
    }
  }

  public boolean isEveryAnswerRight(AnswerContainer answerContainer) {
    for (Answer answer : answerContainer.getAnswers()) {
      if (!answer.getAnswer().equals(questionRepository.findById(answer.getId()).getAnswer())) {
        return false;
      }
    }
    return true;
  }
}
