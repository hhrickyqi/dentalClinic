package com.ricky.dentalclinic.dental.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface DataAnalysisDao {
    int countTotalCase(@Param("year") String year);

    int countPerMonth(@Param("month") String month);

    List<Date> getAllBirthday(@Param("year") String year);
}
