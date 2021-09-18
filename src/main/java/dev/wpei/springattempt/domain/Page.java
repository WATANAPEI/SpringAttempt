package dev.wpei.springattempt.domain;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Page {
    private String prefecture;
    private String from;
    private String to;
    private LocalDateTime createdAt;
}
