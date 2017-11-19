package com.willshuhua.adibioadmin.service.impl;

import com.willshuhua.adibioadmin.dao.AnalysisDao;
import com.willshuhua.adibioadmin.dao.OrderDao;
import com.willshuhua.adibioadmin.dao.PatientDao;
import com.willshuhua.adibioadmin.dao.ProductDao;
import com.willshuhua.adibioadmin.entity.analysis.Analysis;
import com.willshuhua.adibioadmin.entity.order.OrderInfo;
import com.willshuhua.adibioadmin.entity.order.OrderPatientInfo;
import com.willshuhua.adibioadmin.entity.patient.PatientInfo;
import com.willshuhua.adibioadmin.entity.product.Product;
import com.willshuhua.adibioadmin.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnalysisServiceImpl implements AnalysisService{

    @Autowired
    AnalysisDao analysisDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    PatientDao patientDao;

    @Override
    public void insertAnalysis(Analysis analysis) {
        analysisDao.insertAnalysis(analysis);
    }

    @Transactional
    @Override
    public Map<String, Object> getAnalysisInfo(String orderInfoid) {
        Analysis analysis = analysisDao.selectAnalysis(orderInfoid);
        if (analysis == null){
            return null;
        }
        Map<String, Object> analysisInfo = new HashMap<>();
        analysisInfo.put("analysis", analysis);
        OrderInfo orderInfo = orderDao.selectOrderInfo(orderInfoid);
        Product product = productDao.selectProduct(orderInfo.getProduct_id());
        analysisInfo.put("product_name", product.getProduct_name());
        OrderPatientInfo orderPatientInfo = patientDao.selectOrderPatientInfo(orderInfoid);
        analysisInfo.put("patient_info", orderPatientInfo);

        return analysisInfo;
    }

    @Override
    public void updateAnalysis(Analysis analysis) {
        analysisDao.updateAnalysis(analysis);
    }

    @Override
    public void deleteAnalysis(String analysisId) {
        analysisDao.deleteAnalysis(analysisId);
    }
}
