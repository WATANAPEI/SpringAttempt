package dev.wpei.springattempt.controller;

import lombok.Data;

@Data
public class ItemResource {
    private SResource prefecture;
    private SResource to;
    private SResource from;
}
