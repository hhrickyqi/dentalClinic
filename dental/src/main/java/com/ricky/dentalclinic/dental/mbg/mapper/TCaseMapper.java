package com.ricky.dentalclinic.dental.mbg.mapper;

import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.mbg.model.TCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCaseMapper {
    long countByExample(TCaseExample example);

    int deleteByExample(TCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCase record);

    int insertSelective(TCase record);

    List<TCase> selectByExample(TCaseExample example);

    TCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCase record, @Param("example") TCaseExample example);

    int updateByExample(@Param("record") TCase record, @Param("example") TCaseExample example);

    int updateByPrimaryKeySelective(TCase record);

    int updateByPrimaryKey(TCase record);
}