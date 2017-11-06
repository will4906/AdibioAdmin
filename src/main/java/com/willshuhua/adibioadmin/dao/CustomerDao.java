package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.customer.CustomerWechat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {

    CustomerWechat selectCustomerWechat(@Param("customer_id")String customerId);
}
