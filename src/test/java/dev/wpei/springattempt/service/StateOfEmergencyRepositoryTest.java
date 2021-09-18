package dev.wpei.springattempt.service;

import dev.wpei.springattempt.config.RepositoryConfig;
import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.repository.StateOfEmergencyRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(StateOfEmergencyRepository.class)
//@ContextConfiguration(classes = {MockRestServiceServerAutoConfiguration.class, RestTemplateAutoConfiguration.class, RepositoryConfig.class, StateOfEmergencyRepository.class})
//@ContextConfiguration(classes = {MockRestServiceServerAutoConfiguration.class})
@ActiveProfiles("test")
public class StateOfEmergencyRepositoryTest {

    @Autowired
    StateOfEmergencyRepository stateOfEmergencyRepository;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void getPageReturnsPageOfGivenPrefecture() throws UnsupportedEncodingException {
        String prefecture = URLEncoder.encode("千葉県", "UTF-8");
        String rawPrefecture = "千葉県";
        //String responseJson = "{\"prefecture\": \"千葉県\", \"from\": \"20210802\", \"to\": \"20210912\",\"createdAt\":null}";
        String responseJson = "{\"Item\":{\"prefecture\":{\"S\":\"千葉県\"},\"to\":{\"S\":\"20210912\"},\"from\":{\"S\":\"20210802\"}}}";
        this.server.expect(requestTo(stateOfEmergencyRepository.getAccessUrl(prefecture)))
                .andRespond(withSuccess(responseJson, MediaType.APPLICATION_JSON));

        Page expected = Page.builder()
                .prefecture("千葉県")
                .from("20210802")
                .to("20210912")
                .createdAt(null)
                .build();

        Page actual = stateOfEmergencyRepository.get(rawPrefecture);
        MatcherAssert.assertThat(actual, equalTo(expected));

    }
}
