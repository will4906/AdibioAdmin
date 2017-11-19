package com.willshuhua.adibioadmin.service;

import com.willshuhua.adibioadmin.entity.analysis.Analysis;

import java.util.Map;

public interface AnalysisService {

    void insertAnalysis(Analysis analysis);

    Map<String, Object> getAnalysisInfo(String orderInfoid);

    void updateAnalysis(Analysis analysis);
}
