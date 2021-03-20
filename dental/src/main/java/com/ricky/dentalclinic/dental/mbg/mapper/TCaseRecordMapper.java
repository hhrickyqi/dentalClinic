package com.ricky.dentalclinic.dental.mbg.mapper;

import com.ricky.dentalclinic.dental.mbg.model.TCaseRecord;
import com.ricky.dentalclinic.dental.mbg.model.TCaseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCaseRecordMapper {
    long countByExample(TCaseRecordExample example);

    int deleteByExample(TCaseRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCaseRecord record);

    int insertSelective(TCaseRecord record);

    List<TCaseRecord> selectByExample(TCaseRecordExample example);

    TCaseRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCaseRecord record, @Param("example") TCaseRecordExample example);

    int updateByExample(@Param("record") TCaseRecord record, @Param("example") TCaseRecordExample example);

    int updateByPrimaryKeySelective(TCaseRecord record);

    int updateByPrimaryKey(TCaseRecord record);
}