package dev.wpei.springattempt.controller;

import dev.wpei.springattempt.repository.StateOfEmergencyRepository;
import dev.wpei.springattempt.service.PageSaveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@ActiveProfiles("test")
@WebMvcTest(PageController.class)
public class LocalStateOfEmergencyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PageSaveService pageSaveServiceMock;

    @MockBean
    private StateOfEmergencyRepository repository;

    @Test
    public void getPagesReturn200 () throws Exception {
        //Mockito.doReturn(new Page()).when(pageFetchServiceMock).getPage("千葉県");
        mockMvc.perform(get("/api/v1/pages"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPageReturn200 () throws Exception {
        String paramValue = "千葉県";
        mockMvc.perform(get("/api/v1/page").queryParam("prefecture", URLEncoder.encode(paramValue, StandardCharsets.UTF_8)))
                .andExpect(status().isOk());
    }

}
