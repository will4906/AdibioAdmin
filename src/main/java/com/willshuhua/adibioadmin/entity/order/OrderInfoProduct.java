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
}
