package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.CaseInfoParam;
import com.ricky.dentalclinic.dental.domain.CaseQueryParam;
import com.ricky.dentalclinic.dental.domain.CaseResultWithDentist;
import com.ricky.dentalclinic.dental.domain.DentistParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;

import java.util.Date;
import java.util.List;

public interface CaseService {
    /*
    添加病人信息
     */
    int insertCase(String name, String sex, String birthday, String phoneNumber, String identityCard, Integer dentistId);

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
    List<CaseResultWithDentist> listCase(CaseQueryParam queryParam, Integer pageSize, Integer pageNum);

    /*
    验证身份证是否重复
     */
    List<TCase> verifyIdCard(String identityCard);

    /*
    医师查询病人信息
     */
    List<CaseResultWithDentist> listCaseByDentist(CaseQueryParam queryParam, Integer pageSize, Integer pageNum);

    /*
    获取医师列表
     */
    List<DentistParam> dentistList();
}
