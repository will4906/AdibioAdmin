package com.willshuhua.adibioadmin.service;

import com.willshuhua.adibioadmin.dao.OrderDao;
import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    List<Order> selectLatestOrders(OrderQuery orderQuery);

    List<Order> selectPartOrders(OrderQuery orderQuery);

    Map<String, Object> getOrderDetail(String orderId);
}