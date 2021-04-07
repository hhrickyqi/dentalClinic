package com.ricky.dentalclinic.dental.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class CaseDateAnalysisResult {
    private int TotalCase;  //总接待病人数

    private LinkedHashMap<String, Integer> perMonthCase;//每月病人数
}
