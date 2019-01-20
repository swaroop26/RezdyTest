package com.rezdy.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rezdy.task.model.Recipes;
import com.rezdy.task.service.LunchService;

@RestController
public class LunchController {

	@Autowired
	LunchService lunchService;

	@RequestMapping("/lunch")
	public Recipes getLunch() {
		return lunchService.getLunch();
	}

}
