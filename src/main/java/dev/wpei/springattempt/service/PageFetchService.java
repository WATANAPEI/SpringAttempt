package dev.wpei.springattempt.service;

import dev.wpei.springattempt.dto.PageResponseDto;
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

    public Page getPage(String prefecture) {
        String uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("l1ncqf4mxg.execute-api.ap-northeast-1.amazonaws.com")
                .path("/dev/stateofemergency")
                .query("prefecture={prefecture}")
                .buildAndExpand(prefecture)
                //.encode()
                .toUriString();
        System.out.println("URL: " + uri);
        PageResponseDto response = this.restTemplate.getForEntity(uri, PageResponseDto.class).getBody();
        System.out.println("response: " + response);
        Page page = new Page();
        page.setPrefecture(response.getItem().getPrefecture().getS());
        page.setFrom(response.getItem().getFrom().getS());
        page.setTo(response.getItem().getTo().getS());
        return page;
    }
}
