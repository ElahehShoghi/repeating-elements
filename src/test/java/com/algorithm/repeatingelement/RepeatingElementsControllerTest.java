package com.algorithm.repeatingelement;

import com.algorithm.repeatingelement.controller.RepeatingElementsController;
import com.algorithm.repeatingelement.service.RepeatingElementsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RepeatingElementsControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new RepeatingElementsController(new RepeatingElementsService())).build();
    }

    @Test
    public void getRepeatingElementsByTwoLoop() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/repeating-elements/by-two-loop")
                .queryParam("inputArray", "1, 1, 3, 0, 2, 3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getRepeatingElementsBySet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/repeating-elements/by-set")
                .queryParam("inputArray", "1, 1, 3, 0, 2, 3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getRepeatingElementsByHashTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/repeating-elements/by-hashtable")
                .queryParam("inputArray", "1, 1, 3, 0, 2, 3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
