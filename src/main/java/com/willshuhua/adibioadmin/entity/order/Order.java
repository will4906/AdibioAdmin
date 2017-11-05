package com.willshuhua.adibioadmin.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long row_id;
    private String order_id;
    private String customer_id;
    private BigDecimal price;
    private String status;
    private String description;

}
