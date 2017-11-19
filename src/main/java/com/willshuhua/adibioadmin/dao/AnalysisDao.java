package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.analysis.Analysis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisDao {

    void insertAnalysis(Analysis analysis);

    Analysis selectAnalysis(@Param("order_infoid")String orderInfoid);

    void updateAnalysis(Analysis analysis);
}
