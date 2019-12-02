package com.tedu.sp06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;

@RestController
public class RibbonController {
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/item-service/{orderId}")
	@HystrixCommand(fallbackMethod = "getItemsFB")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
	    //向指定微服务地址发送 get 请求，并获得该服务的返回结果 
	    //{1} 占位符，用 orderId 填充
		return rt.getForObject("http://item-service/{1}", JsonResult.class, orderId);
	}

	@PostMapping("/item-service/decreaseNumber")
	@HystrixCommand(fallbackMethod = "decreaseNumberFB")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
	    //发送 post 请求
		return rt.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
	}

	
	@GetMapping("/user-service/{userId}")
	@HystrixCommand(fallbackMethod = "getUserFB")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		return rt.getForObject("http://user-service/{1}", JsonResult.class, userId);
	}

	@GetMapping("/user-service/{userId}/score") 
	@HystrixCommand(fallbackMethod = "addScoreFB")
	public JsonResult addScore(
			@PathVariable Integer userId, Integer score) {
		return rt.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
	}
	
	
	@GetMapping("/order-service/{orderId}")
	@HystrixCommand(fallbackMethod = "getOrderFB")
	public JsonResult<Order> getOrder(@PathVariable String orderId) {
		return rt.getForObject("http://order-service/{1}", JsonResult.class, orderId);
	}

	@GetMapping("/order-service")
	@HystrixCommand(fallbackMethod = "addOrderFB")
	public JsonResult addOrder() {
		return rt.getForObject("http://order-service/", JsonResult.class);
	}
	
	public JsonResult<List<Item>> getItemsFB(@PathVariable String orderId) {
		return JsonResult.err("获取订单的商品列表失败");
	}
	
	public JsonResult decreaseNumberFB(@RequestBody List<Item> items) {
		return JsonResult.err("减少商品数量失败");
	}
	
	
	public JsonResult<User> getUserFB(@PathVariable Integer userId) {
		return JsonResult.err("获取用户信息失败");
	}
	
	public JsonResult addScoreFB(@PathVariable Integer userId, Integer score) {
		return JsonResult.err("获取用户信息失败");
	}
	
	
	public JsonResult<Order> getOrderFB(@PathVariable String orderId) {
		return JsonResult.err("获取订单信息失败");
	}
	
	public JsonResult addOrderFB() {
		return JsonResult.err("获取订单信息失败");
	}
	
	
}

