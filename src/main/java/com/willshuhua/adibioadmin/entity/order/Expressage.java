package com.willshuhua.adibioadmin.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expressage {

    private String expressage_id;
    private String order_infoid;
    private String company;
    private String expressage_number;

}
