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
    
    private String create_time;
    
    public Order(long row_id, String order_id, String customer_id, BigDecimal price, String status, String description){
        this.row_id = row_id;
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.price = price;
        this.status = status;
        this.description = description;
    }

}
