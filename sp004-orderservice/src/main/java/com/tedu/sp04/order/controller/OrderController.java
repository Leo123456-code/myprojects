package com.tedu.sp04.order.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.pojo.User;
import com.tedu.sp01.service.OrderService;
import com.tedu.web.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@GetMapping("/{orderId}")
	public JsonResult<Order> getOrder(@PathVariable String orderId){
		Order order = orderservice.getOrder(orderId);
		return JsonResult.ok(order);
	}
	
	
	@GetMapping("/")
	public JsonResult addOrder() {
		Order order = new Order();
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item(1, "item1", 1));
		order.setId("123");
		order.setItems(list);
		order.setUser(new User(1, "username", "password"));
		orderservice.addOrder(order);
		return JsonResult.ok();
	}
	
	
}
