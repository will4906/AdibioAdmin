package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.order.Order;
import com.willshuhua.adibioadmin.entity.order.OrderEvent;
import com.willshuhua.adibioadmin.entity.order.OrderInfo;
import com.willshuhua.adibioadmin.entity.order.OrderInfoProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {

    List<Order> selectLatestOrders(OrderQuery orderQuery);

    List<Order> selectPartOrders(OrderQuery orderQuery);

    Order selectOrder(@Param("order_id") String orderId);

    List<OrderEvent> selectOrderEvent(@Param("order_id")String orderId);

    List<OrderInfoProduct> selectOrderInfo(@Param("order_id")String orderId);

    Map<String, String> selectOrderIdByOrderInfoid(@Param("order_infoid")String orderInfoid);
}
