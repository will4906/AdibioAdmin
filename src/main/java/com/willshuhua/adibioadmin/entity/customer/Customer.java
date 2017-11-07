package com.willshuhua.adibioadmin.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customer_id;
    private String telphone;
    private String email;
    private String openid;
    private Date register_time;
    private String zhifubao_account;
    private String bank_card_number;

}
