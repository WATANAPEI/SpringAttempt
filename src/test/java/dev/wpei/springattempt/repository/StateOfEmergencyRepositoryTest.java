package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.domain.LocalStateOfEmergency;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(StateOfEmergencyRepository.class)
//@ContextConfiguration(classes = {MockRestServiceServerAutoConfiguration.class, RestTemplateAutoConfiguration.class, RepositoryConfig.class, StateOfEmergencyRepository.class})
//@ContextConfiguration(classes = {MockRestServiceServerAutoConfiguration.class})
@ActiveProfiles("test")
public class StateOfEmergencyRepositoryTest {

    @Autowired
    private StateOfEmergencyRepository stateOfEmergencyRepository;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void getPageReturnsPageOfGivenPrefecture() {
        String prefecture = URLEncoder.encode("chiba", StandardCharsets.UTF_8);
        String rawPrefecture = "chiba";
        String responseJson = "{\"Item\":{\"prefecture\":{\"S\":\"chiba\"},\"to\":{\"S\":\"20210912\"},\"from\":{\"S\":\"20210802\"},\"prefecture_name\":\"千葉県\"}}";
        this.server.expect(requestTo(stateOfEmergencyRepository.getAccessUrl(prefecture)))
                .andRespond(withSuccess(responseJson, MediaType.APPLICATION_JSON));

        LocalStateOfEmergency expected = LocalStateOfEmergency.builder()
                .prefecture("chiba")
                .effectiveFrom("20210802")
                .effectiveTo("20210912")
                .prefectureName("千葉県")
                .build();

        LocalStateOfEmergency actual = stateOfEmergencyRepository.get(rawPrefecture);
        MatcherAssert.assertThat(actual, equalTo(expected));

    }
}
