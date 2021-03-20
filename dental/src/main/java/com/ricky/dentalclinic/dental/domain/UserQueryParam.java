package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryParam {
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("联系电话")
    private String phoneNumber;
    @ApiModelProperty("用户类型")
    private Integer type;
}
