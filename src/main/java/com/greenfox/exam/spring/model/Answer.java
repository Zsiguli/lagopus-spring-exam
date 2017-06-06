package com.greenfox.exam.spring.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Answer {

  private Long id;
  private String answer;
}
