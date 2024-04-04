package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(DemoApplication.class)
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        // given
        String expectedResult = "hello1";

        // when
        ResultActions result = mockMvc.perform(get("/hi"));

        // then
        result.andExpect(status().isOk());
        String responseContent = result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        assertThat(responseContent).isEqualTo(expectedResult);
    }
}
