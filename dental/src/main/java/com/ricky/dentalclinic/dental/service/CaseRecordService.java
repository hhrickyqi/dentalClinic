package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.CaseRecordParam;
import com.ricky.dentalclinic.dental.domain.CaseRecordQueryParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;

import java.math.BigDecimal;
import java.util.List;

public interface CaseRecordService {

    /*
    删除诊断及治疗信息
     */
    int deleteCaseRecord(int id);

    /*
    添加诊断及治疗信息
     */
    int insertCaseRecord(int caseId, int dentistId, String record);

    /*
    修改诊断及治疗信息
     */
    int updateCaseRecord(int id, String record);

    /*
    查询诊断及治疗信息
     */
    List<CaseRecordParam> listCaseRecord(CaseRecordQueryParam queryParam, Integer pageSize, Integer pageNum);

    /*
    添加收费
     */
    int treatmentCharge(int id, BigDecimal price);

    /*
    修改费用
     */
    int updateCharge(int id, BigDecimal price);
}
