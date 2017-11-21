package com.willshuhua.adibioadmin.service.impl;

import com.willshuhua.adibioadmin.dao.PatientDao;
import com.willshuhua.adibioadmin.entity.order.OrderPatientInfo;
import com.willshuhua.adibioadmin.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientDao patientDao;

    @Override
    public OrderPatientInfo selectOrderPatientInfoByOrderPatientInfoId(String orderPatientInfoId) {
        return patientDao.selectOrderPatientInfoByOrderPatientInfoId(orderPatientInfoId);
    }

    @Override
    public void updateOrderPatientInfo(OrderPatientInfo orderPatientInfo) {
        patientDao.updateOrderPatientInfo(orderPatientInfo);
    }
}
