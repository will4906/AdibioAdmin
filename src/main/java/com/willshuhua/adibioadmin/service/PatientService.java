package com.willshuhua.adibioadmin.service;

import com.willshuhua.adibioadmin.dao.PatientDao;
import com.willshuhua.adibioadmin.entity.order.OrderPatientInfo;
import org.springframework.beans.factory.annotation.Autowired;

public interface PatientService {

    OrderPatientInfo selectOrderPatientInfoByOrderPatientInfoId(String orderPatientInfoId);

    void updateOrderPatientInfo(OrderPatientInfo orderPatientInfo);
}
