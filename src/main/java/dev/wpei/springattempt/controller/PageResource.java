package dev.wpei.springattempt.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageResource {
    @JsonProperty("Item")
    private ItemResource item;

}
