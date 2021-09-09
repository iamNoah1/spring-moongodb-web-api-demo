package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TodoController.class)
public class TodoControllerUnitTester {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository repo;

    @Test
    public void addTodoShouldReturn400IfNoBodyWasProvided() throws Exception{
        when(repo.save(isA(TodoModel.class))).thenReturn(new TodoModel());

        this.mockMvc.perform(post("/todo"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void addTodoShouldReturn200AndPersistedTodoIfPersistingWasSuccessful() throws Exception{
        when(repo.save(isA(TodoModel.class))).thenReturn(new TodoModel());

        this.mockMvc.perform(post("/todo")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"description\" : \"blabla\"}"))
            .andExpect(status().isOk());
    }

}
