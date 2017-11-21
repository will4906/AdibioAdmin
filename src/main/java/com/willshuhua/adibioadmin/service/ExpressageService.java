package com.willshuhua.adibioadmin.service;

import com.willshuhua.adibioadmin.entity.order.Expressage;

public interface ExpressageService {

    Expressage selectExpressage(String expressageId);

    Expressage selectExpressageByOrderInfoid(String orderInfoid);

    void insertExpressage(Expressage expressage);

    void updateExpressage(Expressage expressage);
}
