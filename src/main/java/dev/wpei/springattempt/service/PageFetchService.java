package dev.wpei.springattempt.service;

import dev.wpei.springattempt.domain.Page;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class PageFetchService {
    private final RestTemplate restTemplate;
    private final String gatewayPath = "https://l1ncqf4mxg.execute-api.ap-northeast-1.amazonaws.com/dev/stateofemergency";

    public PageFetchService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Page getPage(String prefecture) {
        String uri = UriComponentsBuilder.fromPath(gatewayPath)
                .query("prefecture={prefecture")
                .buildAndExpand(prefecture)
                .encode()
                .toUriString();
        return this.restTemplate.getForEntity(uri, Page.class).getBody();
    }
}
