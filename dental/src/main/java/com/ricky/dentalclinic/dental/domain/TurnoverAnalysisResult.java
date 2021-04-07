package com.ricky.dentalclinic.dental.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

@Setter
@Getter
public class TurnoverAnalysisResult {
    private BigDecimal totalTurnover;   //总营业额

    private LinkedHashMap<String, BigDecimal> preMonthTurnover = new LinkedHashMap<>(); //每月营业额
}
