package com.willshuhua.adibioadmin.service.impl;

import com.willshuhua.adibioadmin.dao.CustomerDao;
import com.willshuhua.adibioadmin.dao.OrderDao;
import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.customer.Customer;
import com.willshuhua.adibioadmin.entity.customer.CustomerWechat;
import com.willshuhua.adibioadmin.entity.order.Order;
import com.willshuhua.adibioadmin.entity.order.OrderEvent;
import com.willshuhua.adibioadmin.entity.order.OrderInfo;
import com.willshuhua.adibioadmin.entity.order.OrderInfoProduct;
import com.willshuhua.adibioadmin.entity.share.OrderCashback;
import com.willshuhua.adibioadmin.entity.share.Share;
import com.willshuhua.adibioadmin.service.OrderService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao;
    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Order> selectLatestOrders(OrderQuery orderQuery) {
        return orderDao.selectLatestOrders(orderQuery);
    }

    @Override
    public List<Order> selectPartOrders(OrderQuery orderQuery) {
        return orderDao.selectPartOrders(orderQuery);
    }

    @Override
    public Map<String, Object> getOrderDetail(String orderId) {
        Order order = orderDao.selectOrder(orderId);
        CustomerWechat customerWechat = customerDao.selectCustomerWechat(order.getCustomer_id());
        List<OrderEvent> eventList = orderDao.selectOrderEvent(orderId);
        List<OrderInfoProduct> infoList = orderDao.selectOrderInfoProduct(orderId);
        Map<String, Object> orderDetail = new HashMap<>();
        orderDetail.put("order", order);
        orderDetail.put("wechat", customerWechat);
        orderDetail.put("events", eventList);
        orderDetail.put("infos", infoList);
        return orderDetail;
    }

    @Override
    public Map<String, String> selectOrderIdByOrderInfoid(String orderInfoId) {
        return orderDao.selectOrderIdByOrderInfoid(orderInfoId);
    }

    @Override
    public List<Object> selectLatestCashbackInfo(int limit, boolean paid) {
        List<Object> cashList = new ArrayList<>();
        List<Share> shareList = orderDao.selectLatestShares(limit, paid);
        for (Share share : shareList){
            Map<String, Object> shareMap = new HashMap<>();
            List<OrderCashback> orderCashbacks = orderDao.selectOrderCashback(share.getOrder_id());
            BigDecimal whole = new BigDecimal(0);
            for (OrderCashback orderCashback : orderCashbacks){
                whole = whole.add(orderCashback.getCashback());
            }
            Customer customer = customerDao.selectCustomer(share.getFrom_id());
            customer.setOpenid(null);
            shareMap.put("share", share);
            shareMap.put("cashbacks", orderCashbacks);
            shareMap.put("customer", customer);
            shareMap.put("whole_cashback", whole);
            cashList.add(shareMap);
        }
        return cashList;
    }

    @Override
    public List<Object> selectPartCashbackInfo(int limit, long start_row, boolean paid) {
        List<Object> cashList = new ArrayList<>();
        List<Share> shareList = orderDao.selectPartShares(limit, start_row, paid);
        for (Share share : shareList){
            Map<String, Object> shareMap = new HashMap<>();
            List<OrderCashback> orderCashbacks = orderDao.selectOrderCashback(share.getOrder_id());
            BigDecimal whole = new BigDecimal(0);
            for (OrderCashback orderCashback : orderCashbacks){
                whole = whole.add(orderCashback.getCashback());
            }
            Customer customer = customerDao.selectCustomer(share.getFrom_id());
            customer.setOpenid(null);
            shareMap.put("share", share);
            shareMap.put("cashbacks", orderCashbacks);
            shareMap.put("customer", customer);
            shareMap.put("whole_cashback", whole);
            cashList.add(shareMap);
        }
        return cashList;
    }

    @Override
    public void updateShareIsPaid(String shareId, boolean isPaid) {
        orderDao.updateShareIsPaid(shareId, isPaid);
    }
}
