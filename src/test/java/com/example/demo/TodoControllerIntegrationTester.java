package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class TodoControllerIntegrationTester {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addTodoShouldReturn200AndPersistedTodoIfPersistingWasSuccessful() throws Exception{

        this.mockMvc.perform(post("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"description\" : \"blabla\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json(("{\"description\" : \"blabla\"}")));
    }
}
