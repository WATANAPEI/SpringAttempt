package dev.wpei.springattempt.dto.state_of_emergency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateOfEmergencyResponseDto {
    private int count;
    @JsonProperty("Items")
    private List<StateOfEmergencyItemDto> items;
    private int scannedCount;

}
