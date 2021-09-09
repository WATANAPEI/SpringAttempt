package dev.wpei.springattempt.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SResource {
    @JsonProperty("S")
    private String s;
}
