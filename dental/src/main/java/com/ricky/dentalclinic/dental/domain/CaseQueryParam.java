package com.ricky.dentalclinic.dental.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 病历查询参数
 */

public class CaseQueryParam {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "出生日期")
    private String birthday;
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;
    @ApiModelProperty(value = "创建日期")
    private String date;
    @ApiModelProperty(value = "病历号")
    private String caseNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }
}
