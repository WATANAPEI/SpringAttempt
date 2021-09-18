package dev.wpei.springattempt.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

@ConfigurationProperties("repository.external.state-of-emergency")
@Data
@NoArgsConstructor
@Profile({"default,test"})
public class RepositoryConfig {
    private String scheme;
    private String host;
    private String path;
    private int port;
    public String query;
}
