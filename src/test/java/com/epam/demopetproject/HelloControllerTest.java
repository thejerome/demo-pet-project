package com.epam.demopetproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    MockMvc mvc;


    @Test
    void testHello() throws Exception {

        mvc.perform(
                get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));

    }


        @Test
        void testHelloUsername() throws Exception {

            mvc.perform(
                    get("/hello")
                            .param("name", "Johnny Silverhand"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hello, Johnny Silverhand!"));

        }



}