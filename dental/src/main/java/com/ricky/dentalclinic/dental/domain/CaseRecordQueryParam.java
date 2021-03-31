package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseRecordQueryParam {
    @ApiModelProperty("病人姓名")
    private String caseName;
    @ApiModelProperty("治疗医生姓名")
    private String dentistName;
    @ApiModelProperty("记录时间")
    private String date;
    @ApiModelProperty("病例号")
    private String caseNo;
}
