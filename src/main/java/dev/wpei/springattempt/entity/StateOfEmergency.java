package dev.wpei.springattempt.entity;

import lombok.Data;

@Data
public class StateOfEmergency {
    private int id;
    private String prefecture;
    private String effectiveFrom;
    private String effectiveTo;
    private String prefectureName;

}
