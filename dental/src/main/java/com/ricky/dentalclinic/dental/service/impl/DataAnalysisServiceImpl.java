package com.ricky.dentalclinic.dental.service.impl;

import com.ricky.dentalclinic.dental.dao.DataAnalysisDao;
import com.ricky.dentalclinic.dental.domain.CaseAgeAnalysisResult;
import com.ricky.dentalclinic.dental.domain.CaseDateAnalysisResult;
import com.ricky.dentalclinic.dental.domain.TurnoverAnalysisResult;
import com.ricky.dentalclinic.dental.service.DataAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {
    @Autowired
    private DataAnalysisDao dataAnalysisDao;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    @Override
    public CaseDateAnalysisResult caseDateAnalysis(String year) {
        CaseDateAnalysisResult result = new CaseDateAnalysisResult();
        result.setTotalCase(dataAnalysisDao.countTotalCase(year));//每年总接待病人数
        //统计当年每月人数
        LinkedHashMap<String, Integer> perMonthCase = new LinkedHashMap<>();
        for (int i = 1; i <= 9; i++) {
            String month = year + "-0" + i;
            String perMonth = i + "月";
            int perMonthCount = dataAnalysisDao.countPerMonth(month);
            perMonthCase.put(perMonth, perMonthCount);
        }
        for (int i = 10 ; i <= 12; i++) {
            String month = year + "-" + i;
            String perMonth = i + "月";
            int perMonthCount = dataAnalysisDao.countPerMonth(month);
            perMonthCase.put(perMonth, perMonthCount);

        }
        result.setPerMonthCase(perMonthCase);
        return result;
    }

    @Override
    public CaseAgeAnalysisResult caseAgeAnalysis(String year) {
        CaseAgeAnalysisResult result = new CaseAgeAnalysisResult();
        int old = 0;        //老年 66岁以后
        int middleAge = 0;  //中年 41-65
        int youth = 0;      //青年 18-40
        int juvenile = 0;   //少年 7-17
        int child = 0;      //童年 0-6
        List<Date> birthdayList = dataAnalysisDao.getAllBirthday(year);
        for (int i = 0; i < birthdayList.size(); i++) {
            Date birthday = birthdayList.get(i);
            int age = 0;
            try {
                age = getAge(birthday);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (age <= 6) child++;
            if (age > 6 && age <= 17) juvenile++;
            if (age > 17 && age <= 40) youth++;
            if (age > 40 && age <= 65) middleAge++;
            if (age > 65) old++;
        }
        result.setChild(child);
        result.setJuvenile(juvenile);
        result.setYouth(youth);
        result.setMiddleAge(middleAge);
        result.setOld(old);
        return result;
    }

    @Override
    public TurnoverAnalysisResult turnoverAnalysis(String year) {
        TurnoverAnalysisResult result = new TurnoverAnalysisResult();
        //获取总营业额
        BigDecimal totalTurnover = dataAnalysisDao.getTotalTurnover(year);
        result.setTotalTurnover(totalTurnover);
        //每月营业额
        LinkedHashMap<String, BigDecimal> turnover = new LinkedHashMap<>();
        for (int i = 1; i <= 9 ; i++) {
            String month = year + "-0" + i;
            String perMonth = i + "月";
            BigDecimal perMonthTurnover = dataAnalysisDao.getPerMonthTurnover(month);
            turnover.put(perMonth, perMonthTurnover);
        }
        for (int i = 10; i <= 12; i++) {
            String month = year + "-" + i;
            String perMonth = i + "月";
            BigDecimal perMonthTurnover = dataAnalysisDao.getPerMonthTurnover(month);
            turnover.put(perMonth, perMonthTurnover);
        }
        result.setPreMonthTurnover(turnover);
        return result;
    }

    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        } return age;
    }
}
