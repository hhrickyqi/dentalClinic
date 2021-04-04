package com.ricky.dentalclinic.dental.mbg.mapper;

import com.ricky.dentalclinic.dental.mbg.model.TItems;
import com.ricky.dentalclinic.dental.mbg.model.TItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TItemsMapper {
    long countByExample(TItemsExample example);

    int deleteByExample(TItemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TItems record);

    int insertSelective(TItems record);

    List<TItems> selectByExample(TItemsExample example);

    TItems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TItems record, @Param("example") TItemsExample example);

    int updateByExample(@Param("record") TItems record, @Param("example") TItemsExample example);

    int updateByPrimaryKeySelective(TItems record);

    int updateByPrimaryKey(TItems record);
}