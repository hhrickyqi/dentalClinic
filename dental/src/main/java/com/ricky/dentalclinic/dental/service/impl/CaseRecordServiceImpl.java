package com.ricky.dentalclinic.dental.service.impl;

import com.github.pagehelper.PageHelper;
import com.ricky.dentalclinic.dental.dao.CaseRecordDao;
import com.ricky.dentalclinic.dental.domain.CaseRecordParam;
import com.ricky.dentalclinic.dental.domain.CaseRecordQueryParam;
import com.ricky.dentalclinic.dental.mbg.mapper.TCaseRecordMapper;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.mbg.model.TCaseRecord;
import com.ricky.dentalclinic.dental.service.CaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CaseRecordServiceImpl implements CaseRecordService {

    @Autowired
    private TCaseRecordMapper caseRecordMapper;
    @Autowired
    private CaseRecordDao caseRecordDao;

    @Override
    public int deleteCaseRecord(int id) {
        TCaseRecord caseRecord = new TCaseRecord();
        caseRecord.setId(id);
        caseRecord.setIsDelete(1);
        return caseRecordMapper.updateByPrimaryKeySelective(caseRecord);
    }

    @Override
    public int insertCaseRecord(int caseId, int dentistId, String record) {
        TCaseRecord caseRecord = new TCaseRecord();
        caseRecord.setCaseId(caseId);
        caseRecord.setDentistId(dentistId);
        caseRecord.setRecord(record);
        caseRecord.setDate(new Date());
        caseRecord.setIsDelete(0);
        return caseRecordMapper.insert(caseRecord);
    }

    @Override
    public int updateCaseRecord(int id, String record) {
        TCaseRecord caseRecord = new TCaseRecord();
        caseRecord.setId(id);
        caseRecord.setRecord(record);
        return caseRecordMapper.updateByPrimaryKeySelective(caseRecord);
    }

    @Override
    public List<CaseRecordParam> listCaseRecord(CaseRecordQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return caseRecordDao.listCaseRecord(queryParam);
    }

    @Override
    public int treatmentCharge(int id, BigDecimal price) {
        TCaseRecord caseRecord = new TCaseRecord();
        caseRecord.setId(id);
        caseRecord.setPrice(price);
        return caseRecordMapper.updateByPrimaryKeySelective(caseRecord);
    }

    @Override
    public int updateCharge(int id, BigDecimal price) {
        TCaseRecord caseRecord = new TCaseRecord();
        caseRecord.setId(id);
        caseRecord.setPrice(price);
        return caseRecordMapper.updateByPrimaryKeySelective(caseRecord);
    }
}
