package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.config.RepositoryConfig;
import dev.wpei.springattempt.domain.Page;
import dev.wpei.springattempt.dto.state_of_emergency.StateOfEmergencyResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
@EnableConfigurationProperties(RepositoryConfig.class)
class StateOfEmergencyRepositoryImpl implements StateOfEmergencyRepository {
    private final RestTemplate restTemplate;
    private final UriComponentsBuilder uriComponentsBuilder;


    @Autowired
    public StateOfEmergencyRepositoryImpl(RestTemplateBuilder restTemplateBuilder, RepositoryConfig config) {
        this.restTemplate = restTemplateBuilder.build();
        this.uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme(config.getScheme())
                .host(config.getHost())
                .path(config.getPath())
                .port(config.getPort())
                .query(config.getQuery());
    }

    private String buildUriOfGetPage(String prefecture) {
        String uri = uriComponentsBuilder
                .buildAndExpand(prefecture)
                .toUriString();
        System.out.println("URL: " + uri);
        return uri;
    }

    public String getAccessUrl(String prefecture) {
        return buildUriOfGetPage(prefecture);
    }

    @Override
    public Page get(String prefecture) {
        System.out.println("prefecture in get: " + prefecture);
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