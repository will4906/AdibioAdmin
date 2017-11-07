package com.willshuhua.adibioadmin.entity.share;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCashback {

    private String order_id;
    private int quantity;
    private String product_name;
    private BigDecimal unit_price;
    private BigDecimal discount;
    private BigDecimal cashback;
}
