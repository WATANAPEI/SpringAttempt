package dev.wpei.springattempt;

import lombok.Data;

@Data
public class SavePageRequest {
    private String url;
    private String content;
}
