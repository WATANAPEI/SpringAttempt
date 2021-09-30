package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.config.RepositoryConfig;
import dev.wpei.springattempt.domain.LocalStateOfEmergency;
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
    public LocalStateOfEmergency get(String prefecture) {
        System.out.println("prefecture in get: " + prefecture);
        StateOfEmergencyResponseDto response = this.restTemplate.getForEntity(buildUriOfGetPage(prefecture), StateOfEmergencyResponseDto.class).getBody();
        System.out.println("response: " + response);

        LocalStateOfEmergency localStateOfEmergency = new LocalStateOfEmergency();
        localStateOfEmergency.setId(response.getItems().get(0).getId().getN());
        localStateOfEmergency.setPrefecture(response.getItems().get(0).getPrefecture().getS());
        localStateOfEmergency.setEffectiveFrom(response.getItems().get(0).getFrom().getS());
        localStateOfEmergency.setEffectiveTo(response.getItems().get(0).getTo().getS());
        localStateOfEmergency.setPrefectureName(response.getItems().get(0).getPrefectureName().getS());
        return localStateOfEmergency;
    }
}