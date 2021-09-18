package dev.wpei.springattempt.service;

import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.dto.state_of_emergency.StateOfEmergencyItemDto;
import dev.wpei.springattempt.dto.state_of_emergency.StateOfEmergencyResponseDto;
import dev.wpei.springattempt.dto.state_of_emergency.StateOfEmergencySDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class PageFetchServiceTest {
    @MockBean
    RestTemplateBuilder restTemplateBuilderMock;

    @BeforeEach
    public void setUpMock() {
        StateOfEmergencyResponseDto response = new StateOfEmergencyResponseDto(new StateOfEmergencyItemDto(new StateOfEmergencySDto("千葉県"), new StateOfEmergencySDto("20210802"), new StateOfEmergencySDto("20210912")));
        doReturn(response).when(restTemplateBuilderMock).build().getForEntity("dummy", StateOfEmergencyResponseDto.class).getBody();
    }

    @Test
    public void getPageReturnsPageOfGivenPrefecture() {
        Page pageExpected = Page.builder()
                .prefecture("千葉県")
                .from("20210802")
                .to("20210912")
                .createdAt(null)
                .build();
        //PageFetchService service = new PageFetchService(restTemplate);

    }
}
