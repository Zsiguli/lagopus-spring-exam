package com.greenfox.exam.spring.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class QuestionContainer {

  private int id;
  private List<Question> questions;

  public QuestionContainer (List<Question> questions) {
    id = 1;
    this.questions = questions;
  }
}
