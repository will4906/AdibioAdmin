package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.customer.Customer;
import com.willshuhua.adibioadmin.entity.customer.CustomerWechat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {

    CustomerWechat selectCustomerWechat(@Param("customer_id")String customerId);

    Customer selectCustomer(@Param("customer_id") String customerId);
}
