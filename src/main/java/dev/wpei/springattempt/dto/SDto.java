package dev.wpei.springattempt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SDto {
    @JsonProperty("S")
    private String s;
}
