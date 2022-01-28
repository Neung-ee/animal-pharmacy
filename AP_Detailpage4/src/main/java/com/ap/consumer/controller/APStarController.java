package com.ap.consumer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ap.consumer.dao.StarDAO;
import com.ap.consumer.dao.nameDAO;
import com.ap.consumer.vo.Criteria;
import com.ap.consumer.vo.PageDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class APStarController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	StarDAO sDAO;
	
	@Autowired
	nameDAO nDAO;
	
	@RequestMapping("star/{REFINE_ROADNM_ADDR}*")
	public String getallinfo(@PathVariable String REFINE_ROADNM_ADDR, Criteria cri,Model model1) {
		log.info("[CONTROLLER]get getAllInfo..." + cri);
		model1.addAttribute("page1",REFINE_ROADNM_ADDR);
		/* model1.addAttribute("getname2",nDAO.getname2(REFINE_ROADNM_ADDR)); */
		model1.addAttribute("getallinfo",sDAO.getAllInfo(cri));
		model1.addAttribute("pageMaker", new PageDTO(cri, sDAO.getTotalCount(REFINE_ROADNM_ADDR),REFINE_ROADNM_ADDR));
		model1.addAttribute("avg",sDAO.avg(REFINE_ROADNM_ADDR));
		
		return "Star";
	}
	
    @RequestMapping("star/starupdate")
    public String updateinfo(HttpServletRequest req1,Model model1) throws UnsupportedEncodingException {
    	String rv_score = req1.getParameter("rating");
    	String rv_comment = req1.getParameter("text");
    	String REFINE_ROADNM_ADDR = req1.getParameter("NM1");
    	sDAO.starupdate(rv_score,rv_comment,REFINE_ROADNM_ADDR);
    	String encodedParam = URLEncoder.encode(REFINE_ROADNM_ADDR, "UTF-8");
    	encodedParam = encodedParam.replaceAll("\\+", "%20");

          
        return "redirect:/star/" + encodedParam;
    }

 
}