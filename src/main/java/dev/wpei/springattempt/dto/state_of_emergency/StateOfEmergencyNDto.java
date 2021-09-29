package dev.wpei.springattempt.dto.state_of_emergency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateOfEmergencyNDto {
    @JsonProperty("N")
    private String n;
}
