package dev.wpei.springattempt.domain;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
//@Builder
public class LocalStateOfEmergency {
    private int id;
    private String prefecture;
    private String effectiveFrom;
    private String effectiveTo;
    private String prefectureName;
}
