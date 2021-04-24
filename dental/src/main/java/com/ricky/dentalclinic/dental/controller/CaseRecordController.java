package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonPage;
import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.domain.CaseRecordParam;
import com.ricky.dentalclinic.dental.domain.CaseRecordQueryParam;
import com.ricky.dentalclinic.dental.service.CaseRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(tags = "CaseRecordController", description = "诊断及治疗信息管理")
@Controller
@RequestMapping("/caseRecord")
public class CaseRecordController {
    @Autowired
    private CaseRecordService caseRecordService;

    @ApiOperation("添加诊断及治疗信息")
    @PostMapping("/insertCaseRecord")
    @ResponseBody
    public CommonResult insertCaseRecord(@RequestParam int caseId,
                                   @RequestParam int dentistId,
                                   @RequestParam String record) {
        int count = caseRecordService.insertCaseRecord(caseId, dentistId, record);
        if (count > 0 ){
            return CommonResult.success(count,"添加成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除诊断及治疗信息")
    @PostMapping("/deleteCaseRecord")
    @ResponseBody
    public CommonResult deleteCaseRecord(@RequestParam int id) {
        int count = caseRecordService.deleteCaseRecord(id);
        if (count > 0 ){
            return CommonResult.success(count,"删除成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改诊断及治疗信息")
    @PostMapping("/updateCaseRecord")
    @ResponseBody
    public CommonResult updateCase(@RequestParam int id,
                                   @RequestParam String record) {
        int count = caseRecordService.updateCaseRecord(id, record);
        if (count > 0 ){
            return CommonResult.success(count,"修改成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("查询诊断及治疗信息")
    @RequestMapping(value = "/listCaseRecord", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CaseRecordParam>> list(CaseRecordQueryParam queryParam,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CaseRecordParam> caseList = caseRecordService.listCaseRecord(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(caseList));
    }

    @ApiOperation("添加收费")
    @RequestMapping(value = "/treatmentCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult treatmentCharge(@RequestParam int id,
                                        @RequestParam String chargeItems,
                                        @RequestParam BigDecimal price) {
        int count = caseRecordService.treatmentCharge(id, chargeItems, price);
        if (count > 0 ){
            return CommonResult.success(count,"收费完成！");
        }
        return CommonResult.failed();
    }


    @ApiOperation("修改费用")
    @RequestMapping(value = "/updateCharge", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateCharge(@RequestParam int id,
                                     @RequestParam(required = false) String chargeItems,
                                     @RequestParam BigDecimal price) {
        int count = caseRecordService.updateCharge(id, chargeItems, price);
        if (count > 0 ){
            return CommonResult.success(count,"修改费用成功！");
        }
        return CommonResult.failed();
    }
}
