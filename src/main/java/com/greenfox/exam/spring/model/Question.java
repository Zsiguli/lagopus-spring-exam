package com.greenfox.exam.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Question {

  @Id
  private Long id;
  private String question;
  @JsonIgnore
  private String answer;
}
