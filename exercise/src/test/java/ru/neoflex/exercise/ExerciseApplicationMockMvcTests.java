package ru.neoflex.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExerciseApplicationMockMvcTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void calculate_test_1() throws Exception {
		this.mockMvc
				.perform(get("/calculate/100000/31/01-01-2024"))
				.andDo(print())
				.andExpect(content().string("58020"))
				.andExpect(status().isOk());
	}

	@Test
	public void calculate_test_2() throws Exception {
		this.mockMvc
				.perform(get("/calculate/100000/31/01-05-2024"))
				.andDo(print())
				.andExpect(content().string("68259"))
				.andExpect(status().isOk());
	}

}
