package com.greenfox.exam.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControllerTest.class)
@WebAppConfiguration
@EnableWebMvc
public class ControllerTest {

  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

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

  @Test
  public void answerTest_withWrongAswers() throws Exception {
    mockMvc.perform(post("/answers").contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"id\": 1,\n" +
                    "  \"answers\":[\n" +
                    "  {\"id\": 1, \"answer\": \"2017.03.13\"},\n" +
                    "  {\"id\": 3, \"answer\": \"Greeen\"},\n" +
                    "  {\"id\": 2, \"answer\": \"Whippet\"},\n" +
                    "  {\"id\": 7, \"answer\": \"Libra\"},\n" +
                    "  {\"id\": 5, \"answer\": \"1\"}\n" +
                    "  ]\n" +
                    "}"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(0))
            .andExpect(MockMvcResultMatchers.jsonPath("$.answers").value(null));
  }
}

