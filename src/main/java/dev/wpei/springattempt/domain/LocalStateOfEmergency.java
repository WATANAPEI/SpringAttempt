package dev.wpei.springattempt.domain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalStateOfEmergency {
    private int id;
    private String prefecture;
    private String from;
    private String to;
    private String prefecture_name;
}
