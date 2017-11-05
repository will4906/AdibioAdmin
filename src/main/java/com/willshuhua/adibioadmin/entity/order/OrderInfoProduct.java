package com.willshuhua.adibioadmin.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoProduct {

    private String order_id;
    private String order_itemid;
    private String order_infoid;
    private String product_id;
    private String product_name;
    private BigDecimal unit_price;
    private String patient_infoid;

//    pi.name, pi.gender, pi.age, pi.phone, pi.country, pi.province, pi.city, pi.district, pi.address, pi.has_diabetic, pi.height, pi.weight
    private String name;
    private String gender;
    private float age;
    private String country;
    private String province;
    private String city;
    private String district;
    private String address;
    private String phone;
    private int has_diabetic;
    private float height;
    private float weight;

}
