package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemsParam {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "收费项目名")
    private String item;

    @ApiModelProperty(value = "项目费用")
    private BigDecimal cost;
}
