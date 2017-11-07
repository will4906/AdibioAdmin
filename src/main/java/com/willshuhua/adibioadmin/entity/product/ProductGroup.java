package com.willshuhua.adibioadmin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGroup {

    private String product_groupid;
    private String name;
    private String description;
}
