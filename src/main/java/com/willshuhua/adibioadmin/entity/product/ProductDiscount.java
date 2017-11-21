package com.willshuhua.adibioadmin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDiscount {

    private String product_discount_id;
    private String product_id;
    private String discountType;
    private BigDecimal discount;
    private BigDecimal cashback;
    private String description;

}
