package com.ricky.dentalclinic.dental.dao;

import com.ricky.dentalclinic.dental.domain.CaseRecordQueryParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseRecordDao {
    List<TCase> listCaseRecord(@Param("queryParam") CaseRecordQueryParam queryParam);
}
