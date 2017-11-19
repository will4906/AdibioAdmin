package com.willshuhua.adibioadmin.entity.analysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analysis {

    private String analysis_id;
    private String order_infoid;
    private String result;
    private Date collection_date;
    private Date analysis_date;

}
