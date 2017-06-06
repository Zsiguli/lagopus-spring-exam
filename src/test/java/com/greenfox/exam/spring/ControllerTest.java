package com.greenfox.exam.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControllerTest.class)
@WebAppConfiguration
@EnableWebMvc
public class ControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void answerTest_withoutResponseBody() throws Exception {
    mockMvc.perform(post("/answers"))
            .andExpect(status().is4xxClientError());
  }
}
