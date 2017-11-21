package com.willshuhua.adibioadmin.service.impl;

import com.willshuhua.adibioadmin.dao.ExpressageDao;
import com.willshuhua.adibioadmin.entity.order.Expressage;
import com.willshuhua.adibioadmin.service.ExpressageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressageServiceImpl implements ExpressageService{

    @Autowired
    ExpressageDao expressageDao;

    @Override
    public Expressage selectExpressage(String expressageId) {
        return expressageDao.selectExpressage(expressageId);
    }

    @Override
    public Expressage selectExpressageByOrderInfoid(String orderInfoid) {
        return expressageDao.selectExpressageByOrderInfoid(orderInfoid);
    }

    @Override
    public void insertExpressage(Expressage expressage) {
        expressageDao.insertExpressage(expressage);
    }

    @Override
    public void updateExpressage(Expressage expressage) {
        expressageDao.updateExpressage(expressage);
    }
}
