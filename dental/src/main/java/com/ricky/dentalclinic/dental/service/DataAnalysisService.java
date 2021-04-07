package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.CaseDateAnalysisResult;

public interface DataAnalysisService {
    /*
    病人数据分析
     */
    CaseDateAnalysisResult caseDateAnalysis(String year);
}
