package com.willshuhua.adibioadmin.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuery {

    private String customer_id;
    private String order_id;
    private int limit;
    private long start_row;
    private String status;
}
