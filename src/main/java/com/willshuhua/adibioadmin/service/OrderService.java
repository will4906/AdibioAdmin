package com.willshuhua.adibioadmin.service;

import com.willshuhua.adibioadmin.dao.OrderDao;
import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.order.Order;
import com.willshuhua.adibioadmin.entity.order.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    List<Order> selectLatestOrders(OrderQuery orderQuery);

    List<Order> selectPartOrders(OrderQuery orderQuery);

    Map<String, Object> getOrderDetail(String orderId);

    Map<String, String> selectOrderIdByOrderInfoid(String orderInfoId);

    List<Object> selectLatestCashbackInfo(int limit, boolean paid);

    List<Object> selectPartCashbackInfo(int limit, long start_row, boolean paid);

    void updateShareIsPaid(String shareId, boolean isPaid);

    OrderInfo selectOrderInfo(String orderInfoId);
}
