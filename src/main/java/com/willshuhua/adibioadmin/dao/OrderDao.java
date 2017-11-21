package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.order.*;
import com.willshuhua.adibioadmin.entity.share.OrderCashback;
import com.willshuhua.adibioadmin.entity.share.Share;
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

    List<OrderInfoProduct> selectOrderInfoProduct(@Param("order_id")String orderId);

    Map<String, String> selectOrderIdByOrderInfoid(@Param("order_infoid")String orderInfoid);

    List<Share> selectLatestShares(@Param("limit") int limit, @Param("paid")boolean paid);

    List<Share> selectPartShares(@Param("limit") int limit, @Param("start_row") long startRow, @Param("paid")boolean paid);

    List<OrderCashback> selectOrderCashback(@Param("order_id") String orderId);

    void updateShareIsPaid(@Param("share_id") String shareId, @Param("is_paid") boolean isPaid);

    OrderInfo selectOrderInfo(@Param("order_infoid")String orderInfoid);

}
