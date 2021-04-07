package com.ricky.dentalclinic.dental.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class CaseDateAnalysisResult {
    private int TotalCase;  //总接待病人数

    private LinkedHashMap<String, Integer> perMonthCase;//每月病人数

    private int old;        //老年 66岁以后

    private int middleAge;  //中年 41-65

    private int youth;      //青年 18-40

    private int juvenile;   //少年 7-17

    private int child;      //童年 0-6
}
