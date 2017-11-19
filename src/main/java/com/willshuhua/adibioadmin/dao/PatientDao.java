package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.order.OrderPatientInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao {

    OrderPatientInfo selectOrderPatientInfo(@Param("order_infoid")String orderInfoid);

}
