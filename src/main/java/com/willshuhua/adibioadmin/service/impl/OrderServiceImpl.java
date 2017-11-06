package com.willshuhua.adibioadmin.service.impl;

import com.willshuhua.adibioadmin.dao.CustomerDao;
import com.willshuhua.adibioadmin.dao.OrderDao;
import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.customer.CustomerWechat;
import com.willshuhua.adibioadmin.entity.order.Order;
import com.willshuhua.adibioadmin.entity.order.OrderEvent;
import com.willshuhua.adibioadmin.entity.order.OrderInfo;
import com.willshuhua.adibioadmin.entity.order.OrderInfoProduct;
import com.willshuhua.adibioadmin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<OrderInfoProduct> infoList = orderDao.selectOrderInfo(orderId);
        Map<String, Object> orderDetail = new HashMap<>();
        orderDetail.put("order", order);
        orderDetail.put("wechat", customerWechat);
        orderDetail.put("events", eventList);
        orderDetail.put("infos", infoList);
        return orderDetail;
    }
}
