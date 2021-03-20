package com.ricky.dentalclinic.dental.service.impl;

import com.github.pagehelper.PageHelper;
import com.ricky.dentalclinic.dental.dao.CaseDao;
import com.ricky.dentalclinic.dental.domain.CaseInfoParam;
import com.ricky.dentalclinic.dental.domain.CaseQueryParam;
import com.ricky.dentalclinic.dental.mbg.mapper.TCaseMapper;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CaseServiceImpl implements CaseService {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private TCaseMapper caseMapper;
    @Autowired
    private CaseDao caseDao;

    @Override
    public int insertCase(String name, String sex, String birthday, String phoneNumber) {
        TCase tCase = new TCase();
        tCase.setName(name);
        tCase.setSex(sex);
        Date date = null;
        try {
            date = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tCase.setBirthday(date);
        tCase.setPhoneNumber(phoneNumber);
        tCase.setDate(new Date());
        tCase.setCaseNo(generateCaseNoByDate());
        tCase.setIsDelete(0);
        return caseMapper.insert(tCase);
    }

    @Override
    public int deleteCase(int id) {
        int is_delete = 1;
        return caseDao.deleteCase(id, is_delete);
    }

    @Override
    public int updateCase(CaseInfoParam caseInfo) {
        TCase tCase = new TCase();
        tCase.setId(caseInfo.getId());
        tCase.setName(caseInfo.getName());
        tCase.setSex(caseInfo.getSex());
        tCase.setPhoneNumber(caseInfo.getPhoneNumber());
        Date date = null;
        try {
            date = sdf.parse(caseInfo.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tCase.setBirthday(date);
        return caseMapper.updateByPrimaryKeySelective(tCase);
    }

    @Override
    public List<TCase> listCase(CaseQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return caseDao.listCase(queryParam);
    }

    //生成病历号
    private String generateCaseNoByDate(){
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        Random r = new Random();
        int number = r.nextInt(9) + 1;
        sb.append(date);
        sb.append(number);
        return sb.toString();
    }
}
