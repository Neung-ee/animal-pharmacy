package com.ap.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APPController {
	
	@GetMapping("/")
	public String index() {
		return "test_comment";
	}
}
