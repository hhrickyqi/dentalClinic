package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonPage;
import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.domain.CaseInfoParam;
import com.ricky.dentalclinic.dental.domain.CaseQueryParam;
import com.ricky.dentalclinic.dental.domain.CaseResultWithDentist;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "CaseController", description = "病人信息管理")
@Controller
@RequestMapping("/case")
public class CaseController {
    @Autowired
    private CaseService caseService;

    @ApiOperation("添加病人信息")
    @PostMapping("/insertCase")
    @ResponseBody
    public CommonResult insertCase(@RequestParam String name,
                                   @RequestParam String sex,
                                   @RequestParam String birthday,
                                   @RequestParam String phoneNumber,
                                   @RequestParam String identityCard,
                                   @RequestParam Integer dentistId) {
        int count = caseService.insertCase(name, sex, birthday, phoneNumber, identityCard, dentistId);
        if (count >= 0 ){
            return CommonResult.success(count,"添加成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("验证身份证")
    @GetMapping("/verifyIdCard")
    @ResponseBody
    public CommonResult verifyIdCard(@RequestParam String identityCard) {
        List<TCase> caseList = caseService.verifyIdCard(identityCard);
        if (caseList.isEmpty()) {
            return CommonResult.success("病人未登记");
        }
        return CommonResult.success("病人已存在");
    }

    @ApiOperation("删除病人信息")
    @PostMapping("/deleteCase")
    @ResponseBody
    public CommonResult deleteCase(@RequestParam int id) {
        int count = caseService.deleteCase(id);
        if (count >= 0 ){
            return CommonResult.success(count,"删除成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改病人信息")
    @PostMapping("/updateCase")
    @ResponseBody
    public CommonResult updateCase(@RequestBody CaseInfoParam caseInfo) {
        int count = caseService.updateCase(caseInfo);
        if (count >= 0 ){
            return CommonResult.success(count,"修改成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("医师查询病人信息")
    @RequestMapping(value = "/listCaseByDentist", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CaseResultWithDentist>> listCaseByDentist(CaseQueryParam queryParam,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CaseResultWithDentist> caseList = caseService.listCaseByDentist(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(caseList));
    }

    @ApiOperation("查询病人信息")
    @RequestMapping(value = "/listCase", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CaseResultWithDentist>> list(CaseQueryParam queryParam,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CaseResultWithDentist> caseList = caseService.listCase(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(caseList));
    }
}
