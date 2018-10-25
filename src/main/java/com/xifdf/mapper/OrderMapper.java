package com.xifdf.mapper;

import com.xifdf.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> listOrder();
    Order getOrder(int id);
}
