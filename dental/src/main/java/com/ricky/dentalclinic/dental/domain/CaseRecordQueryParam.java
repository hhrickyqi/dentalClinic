package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseRecordQueryParam {
    @ApiModelProperty("病历id")
    private Integer caseId;
    @ApiModelProperty("治疗医生id")
    private Integer dentistId;
    @ApiModelProperty("记录时间")
    private String date;
}
