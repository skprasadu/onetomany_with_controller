package com.example.hrspringbootwebtest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class TestAuthorRESTController {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mvc;

	@BeforeEach
	public void getContext() {
		mvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void createProjectEmployeeAPI() throws Exception {
		String json = "{\"authorId\":1,\"name\":\"myProj\", \"books\": [{\"bookId\":1, \"name\": \"k@p.com\"}]}";
		
		mvc.perform(MockMvcRequestBuilders.post("/author")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.authorId").exists());
		
		mvc.perform(MockMvcRequestBuilders.get("/author/{id}", 1)
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.authorId").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.books[0].name").value("k@p.com"));
	}

}
