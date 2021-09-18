package dev.wpei.springattempt.controller;

import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.service.PageFetchService;
import dev.wpei.springattempt.service.PageSaveService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URLEncoder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
@WebMvcTest(PageController.class)
public class PageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PageFetchService pageFetchServiceMock;

    @MockBean
    private PageSaveService pageSaveServiceMock;

    @Test
    public void getPagesReturn200 () throws Exception {
        //Mockito.doReturn(new Page()).when(pageFetchServiceMock).getPage("千葉県");
        mockMvc.perform(get("/api/v1/pages"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPageReturn200 () throws Exception {
        String paramValue = "千葉県";
        mockMvc.perform(get("/api/v1/page").queryParam("prefecture", URLEncoder.encode(paramValue, "UTF-8")))
                .andExpect(status().isOk());
    }

}
