package com.ricky.dentalclinic.dental.service.impl;

import com.ricky.dentalclinic.dental.dao.CaseDao;
import com.ricky.dentalclinic.dental.mbg.mapper.TCaseMapper;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
