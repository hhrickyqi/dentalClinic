package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class CaseResultWithDentist {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "病人姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "身份证")
    private String identityCard;

    @ApiModelProperty(value = "出生日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    @ApiModelProperty(value = "治疗医师id")
    private Integer dentistId;

    @ApiModelProperty(value = "治疗医师姓名")
    private String dentistName;

    @ApiModelProperty(value = "日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ApiModelProperty(value = "病历号")
    private String caseNo;

    @ApiModelProperty(value = "是否删除： 0-否 1-是")
    private Integer isDelete;
}
