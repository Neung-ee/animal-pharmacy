package com.ap.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ap.consumer.dao.nameDAO;

@Controller
public class APCController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	nameDAO nDAO;
	
	@RequestMapping("/")
	public String index() {
		return "Detail_page";
	}
	
	@RequestMapping("/{REFINE_ROADNM_ADDR}*")
	public String getallinfo(@PathVariable String REFINE_ROADNM_ADDR, Model model) {
		model.addAttribute("test",REFINE_ROADNM_ADDR);		
		return "Detail_page";
	}

	/*
	 * @RequestMapping(path = "/p/{request}", method = RequestMethod.GET) public
	 * String index(@PathVariable("request") String request, Model model) {
	 * System.out.println(request); model.addAttribute("pageName", request); return
	 * "pages/index"; }
	 */

	//헤더 버튼 클릭시 홈/지도메인으로 이동
	@GetMapping("home")
	public String home() {
		return "home";
	}

}
