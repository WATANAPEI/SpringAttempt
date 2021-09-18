package dev.wpei.springattempt.dto;

import lombok.Data;

@Data
public class SavePageRequestDto {
    private String url;
    private String content;
    private String id;
}
