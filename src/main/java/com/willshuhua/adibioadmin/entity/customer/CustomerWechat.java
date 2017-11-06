package com.willshuhua.adibioadmin.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWechat {

    private String customer_id;
    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String city;
    private String headimgurl;

}
