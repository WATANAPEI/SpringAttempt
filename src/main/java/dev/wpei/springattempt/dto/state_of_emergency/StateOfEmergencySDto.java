package dev.wpei.springattempt.dto.state_of_emergency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateOfEmergencySDto {
    @JsonProperty("S")
    private String s;
}
