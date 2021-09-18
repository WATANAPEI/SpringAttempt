package dev.wpei.springattempt.dto.state_of_emergency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateOfEmergencyItemDto {
    private StateOfEmergencySDto prefecture;
    private StateOfEmergencySDto to;
    private StateOfEmergencySDto from;
}
