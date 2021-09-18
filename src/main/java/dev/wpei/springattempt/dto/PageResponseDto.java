package dev.wpei.springattempt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.wpei.springattempt.dto.ItemDto;
import lombok.Data;

@Data
public class PageResponseDto {
    @JsonProperty("Item")
    private ItemDto item;

}
