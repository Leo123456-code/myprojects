package com.tedu.sp04.order.service;

import org.springframework.stereotype.Service;

import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Order getOrder(String orderId) {
		// TODO 调用商品和用户微服务获取商品和用户信息
		Order order = new Order();
		order.setId(orderId);
		
		return order;
	}

	@Override
	public void addOrder(Order order) {
		
		log.info("保存订单 ：" + order);
	}

}
