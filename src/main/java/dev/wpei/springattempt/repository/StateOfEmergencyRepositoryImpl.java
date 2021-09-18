package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.dto.state_of_emergency.StateOfEmergencyResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
class StateOfEmergencyRepositoryImpl implements StateOfEmergencyRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public StateOfEmergencyRepositoryImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private String buildUriOfGetPage(String prefecture) {
        String uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("l1ncqf4mxg.execute-api.ap-northeast-1.amazonaws.com")
                .path("/dev/stateofemergency")
                .query("prefecture={prefecture}")
                .buildAndExpand(prefecture)
                //.encode()
                .toUriString();
        System.out.println("URL: " + uri);
        return uri;
    }

    @Override
    public Page get(String prefecture) {
        StateOfEmergencyResponseDto response = this.restTemplate.getForEntity(buildUriOfGetPage(prefecture), StateOfEmergencyResponseDto.class).getBody();
        System.out.println("response: " + response);
        Page page = Page.builder()
                .prefecture(response.getItem().getPrefecture().getS())
                .from(response.getItem().getFrom().getS())
                .to(response.getItem().getTo().getS())
                .build();
        return page;
    }
}