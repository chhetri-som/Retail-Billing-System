package com.chhetriSom.billingSoftware.service;

import com.chhetriSom.billingSoftware.io.OrderRequest;
import com.chhetriSom.billingSoftware.io.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);
    void deleteOrder(String orderId);
    List<OrderResponse> getLatestOrders();
}
