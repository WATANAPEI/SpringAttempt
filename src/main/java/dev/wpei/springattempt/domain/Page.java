package dev.wpei.springattempt.domain;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Page {
    private String prefecture;
    private String from;
    private String to;
    private LocalDateTime createdAt;
}
