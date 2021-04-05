package com.ricky.dentalclinic.dental.dao;

import com.ricky.dentalclinic.dental.domain.CaseInfoParam;
import com.ricky.dentalclinic.dental.domain.CaseQueryParam;
import com.ricky.dentalclinic.dental.domain.CaseResultWithDentist;
import com.ricky.dentalclinic.dental.domain.DentistParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseDao {
    int deleteCase(@Param("id") int id, @Param("is_delete") int is_delete);

    List<CaseResultWithDentist> listCase(@Param("queryParam") CaseQueryParam queryParam);

    List<CaseResultWithDentist> listCaseByDentist(@Param("dentistId") int dentistId, @Param("queryParam") CaseQueryParam queryParam);

    List<DentistParam> getDentistList();

}
