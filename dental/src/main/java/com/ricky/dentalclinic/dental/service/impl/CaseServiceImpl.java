package com.ricky.dentalclinic.dental.service.impl;

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
        return caseMapper.insert(tCase);
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
