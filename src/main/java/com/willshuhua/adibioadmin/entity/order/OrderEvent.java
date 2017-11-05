package com.willshuhua.adibioadmin.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private String order_eventid;
    private String order_id;
    private Date event_time;
    private String event_title;
    private String event_executor;      //事件执行者
    private String description;

}
