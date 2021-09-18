package dev.wpei.springattempt.service;

import dev.wpei.springattempt.dto.state_of_emergency.StateOfEmergencyResponseDto;
import dev.wpei.springattempt.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class PageFetchService {
    private final RestTemplate restTemplate;

    @Autowired
    public PageFetchService(RestTemplateBuilder restTemplateBuilder) {
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

    public Page getPage(String prefecture) {
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
