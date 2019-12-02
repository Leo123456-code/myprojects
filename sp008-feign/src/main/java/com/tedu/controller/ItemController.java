package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.service.ItemFerignService;
import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;

@RestController
public class ItemController {
	
	@Autowired
	private ItemFerignService itemFerignService;
	
	

	@GetMapping("item-service/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
		return itemFerignService.getItems(orderId);
	}

	@PostMapping("/item-service/decreaseNumber")
	public JsonResult decreaseNumber(List<Item> items) {
		return itemFerignService.decreaseNumber(items);
	}
	
	
}
