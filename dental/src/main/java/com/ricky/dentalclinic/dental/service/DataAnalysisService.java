package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.CaseAgeAnalysisResult;
import com.ricky.dentalclinic.dental.domain.CaseDateAnalysisResult;
import com.ricky.dentalclinic.dental.domain.TurnoverAnalysisResult;

public interface DataAnalysisService {
    /*
    病人数据分析
     */
    CaseDateAnalysisResult caseDateAnalysis(String year);

    /*
    病人年龄段分析
     */
    CaseAgeAnalysisResult caseAgeAnalysis(String year);

    /*
    营业额分析
     */
    TurnoverAnalysisResult turnoverAnalysis(String year);
}
