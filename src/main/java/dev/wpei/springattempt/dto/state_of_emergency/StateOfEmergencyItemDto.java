package dev.wpei.springattempt.dto.state_of_emergency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateOfEmergencyItemDto {
    private StateOfEmergencyNDto id;
    private StateOfEmergencySDto prefecture;
    private StateOfEmergencySDto to;
    private StateOfEmergencySDto from;
    @JsonProperty("prefecture_name")
    private StateOfEmergencySDto prefectureName;
}
