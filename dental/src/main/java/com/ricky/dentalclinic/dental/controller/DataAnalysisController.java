package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.domain.CaseDateAnalysisResult;
import com.ricky.dentalclinic.dental.service.DataAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "DataAnalysisController", description = "数据分析管理")
@Controller
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {
    @Autowired
    private DataAnalysisService dataAnalysisService;

    @ApiOperation("病人数据分析")
    @GetMapping("/caseDateAnalysis")
    @ResponseBody
    public CommonResult caseDateAnalysis(@RequestParam String year) {
        CaseDateAnalysisResult caseDateAnalysisResult = dataAnalysisService.caseDateAnalysis(year);
        return CommonResult.success(caseDateAnalysisResult);
    }
}
