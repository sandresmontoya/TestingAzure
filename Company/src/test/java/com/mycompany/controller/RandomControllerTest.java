package com.mycompany.controller;

import com.mycompany.model.Random;
import com.mycompany.repository.RandomRepository;
import com.mycompany.service.RandomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = RandomController.class)
public class RandomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RandomService randomService;

    @Test
    public void shouldBeReturn200WhenConsumeUrl() throws Exception {
        //Arrange
        Random random = new Random(51,true);
        when(randomService.getLucky()).thenReturn(random);
        //Act
        MockHttpServletResponse response = mockMvc.perform(get("/company/api/random/getLucky")
                .contentType("application/json"))
                .andReturn().getResponse();
        //Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void shouldBeReturnWinnerWhenRandomIs51() throws Exception {
        //Arrange
        Random random = new Random(51,TRUE);
        when(randomService.getLucky()).thenReturn(random);
        String jsonResponse = "{\"random\":51,\"winner\":true}";

        //Act
        MockHttpServletResponse response = mockMvc.perform(get("/company/api/random/getLucky")
                .contentType("application/json"))
                .andReturn().getResponse();

        //Assert
        assertThat(response.getContentAsString()).isEqualTo(jsonResponse);
    }
}
