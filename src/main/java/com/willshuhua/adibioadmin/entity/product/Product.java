package com.willshuhua.adibioadmin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String product_id;
    private String product_groupid;
    private String product_name;
    private BigDecimal unit_price;
    private String description;
}
