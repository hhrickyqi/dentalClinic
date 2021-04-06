package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.domain.ItemsParam;
import com.ricky.dentalclinic.dental.mbg.model.TItems;
import com.ricky.dentalclinic.dental.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Api(tags = "ItemsController", description = "收费项管理")
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemService itemService;

    @ApiOperation("获取收费项目列表")
    @GetMapping("/getChargeItemList")
    @ResponseBody
    public CommonResult getChargeItemList() {
        List<TItems> itemsList =  itemService.getChargeItemList();
        return CommonResult.success(itemsList);
    }

    @ApiOperation("添加收费项目")
    @PostMapping("/insertChargeItem")
    @ResponseBody
    public CommonResult insertChargeItem(@RequestParam String item,
                                         @RequestParam BigDecimal cost) {
        int count = itemService.insertChargeItem(item, cost);
        if (count > 0){
            return CommonResult.success("添加成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除收费项目")
    @PostMapping("/deleteChargeItem")
    @ResponseBody
    public CommonResult deleteChargeItem(@RequestParam Integer id) {
        int count = itemService.deleteChargeItem(id);
        if (count > 0) {
            return CommonResult.success("删除成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改收费项目")
    @PostMapping("/updateChargeItem")
    @ResponseBody
    public CommonResult updateChargeItem(@RequestBody ItemsParam itemsParam) {
        int count = itemService.updateChargeItem(itemsParam);
        if (count > 0) {
            return CommonResult.success("修改成功！");
        }
        return CommonResult.failed();
    }
}
