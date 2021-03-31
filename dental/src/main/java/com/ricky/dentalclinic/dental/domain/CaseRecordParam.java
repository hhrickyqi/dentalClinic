package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CaseRecordParam {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "病历id")
    private Integer caseId;

    @ApiModelProperty(value = "治疗医生id")
    private Integer dentistId;

    @ApiModelProperty(value = "病人姓名")
    private String caseName;

    @ApiModelProperty(value = "治疗医生姓名")
    private String dentistName;

    @ApiModelProperty(value = "诊断及治疗记录")
    private String record;

    @ApiModelProperty(value = "病例号")
    private String caseNo;

    @ApiModelProperty(value = "记录时间")
    private Date date;

    @ApiModelProperty(value = "本次治疗收费")
    private BigDecimal price;

    @ApiModelProperty(value = "是否删除：0-否 1-是")
    private Integer isDelete;

}
