package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class AnswerContainer {

  private int id;
  private List<Answer> answers;

}
