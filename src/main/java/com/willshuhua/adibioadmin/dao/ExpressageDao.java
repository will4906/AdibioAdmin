package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.order.Expressage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressageDao {

    Expressage selectExpressage(@Param("expressage_id") String expressageId);

    Expressage selectExpressageByOrderInfoid(@Param("order_infoid")String orderInfoid);

    void insertExpressage(Expressage expressage);

    void updateExpressage(Expressage expressage);
}
