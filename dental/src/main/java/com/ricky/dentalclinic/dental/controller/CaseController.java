package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.domain.CaseInfoParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
                                   @RequestParam String phoneNumber) {
        int count = caseService.insertCase(name, sex, birthday, phoneNumber);
        if (count >= 0 ){
            return CommonResult.success(count,"添加成功！");
        }
        return CommonResult.failed();
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
}
