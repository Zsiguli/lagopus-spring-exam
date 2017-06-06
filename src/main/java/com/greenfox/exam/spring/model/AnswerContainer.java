package com.greenfox.exam.spring.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class AnswerContainer {

  private int id;
  private List<Answer> answers;

}
