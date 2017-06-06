package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.Question;
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
    questionRepository.save(new Question(1l, "When did your course start? (yyyy.mm.dd)","2017.03.13"));
    questionRepository.save(new Question(2l, "What type of dog Barbi has?","Whippet"));
    questionRepository.save(new Question(3l, "What is HerrNorbert's favourite color?","Green"));
    questionRepository.save(new Question(4l, "How many classes are learning at Green Fox Academy at this moment?","4"));
    questionRepository.save(new Question(5l, "How many mentors teach at Green Fox at this moment?","16"));
    questionRepository.save(new Question(6l, "What was the name of the first Green Fox class?","Vulpes"));
    questionRepository.save(new Question(7l, "How many likes do we have on facebook?","3300"));
    questionRepository.save(new Question(7l, "What is Tojas's horoscope?","Libra"));
    return new QuestionContainer();
  }
}
