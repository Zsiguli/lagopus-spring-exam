package com.greenfox.exam.spring.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionContainer {

  private int id;
  private List<Question> questions;
}
