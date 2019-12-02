package com.tedu.sp02.item.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.service.ItemService;
import com.tedu.web.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@RequestMapping("/item/")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@Value("${server.port}")
	int port;
	
	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws InterruptedException{
		log.info("server.port" + port + ", orderId=" + orderId);
		
//		if (Math.random()<0.6) {
//			int m = new Random().nextInt(5000);
//			log.info("延迟时间：" + m + "ms");
//			Thread.sleep(m);
//		}
		
		List<Item> items = itemService.getItems(orderId);
		
		return JsonResult.ok(items).msg("port=" + port);
	}
	
	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
	}
	
}
