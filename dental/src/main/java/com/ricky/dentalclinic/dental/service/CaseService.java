package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.CaseInfoParam;

import java.util.Date;

public interface CaseService {
    /*
    添加病人信息
     */
    int insertCase(String name, String sex, String birthday, String phoneNumber);

    /*
    删除病人信息
     */
    int deleteCase(int id);
    /*
    修改病人信息
     */
    int updateCase(CaseInfoParam caseInfo);
}
