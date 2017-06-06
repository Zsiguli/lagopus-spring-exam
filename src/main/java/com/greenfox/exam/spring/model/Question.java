package com.greenfox.exam.spring.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
public class Question {

  @Id
  private Long id;
  private String question;
  private String answer;
}
