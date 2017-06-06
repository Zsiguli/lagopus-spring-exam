package com.greenfox.exam.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

  @Id
  private Long id;
  private String question;
}
