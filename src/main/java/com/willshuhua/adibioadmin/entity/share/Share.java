package com.willshuhua.adibioadmin.entity.share;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Share {

    private long row_id;
    private String share_id;
    private String from_id;
    private String order_id;
    private boolean is_paid;
}
