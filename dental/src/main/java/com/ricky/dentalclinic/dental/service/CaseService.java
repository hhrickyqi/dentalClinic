package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.CaseInfoParam;
import com.ricky.dentalclinic.dental.domain.CaseQueryParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;

import java.util.Date;
import java.util.List;

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

    /*
    查询病人信息
     */
    List<TCase> listCase(CaseQueryParam queryParam, Integer pageSize, Integer pageNum);
}
