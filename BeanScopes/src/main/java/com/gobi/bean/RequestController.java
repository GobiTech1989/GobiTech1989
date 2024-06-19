package com.gobi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	@Autowired
	private RequestBean requestBean;
	
	@Autowired
	private SessionBean sessionBean;

	@GetMapping("/requestScope")
	public String requestScope() {
		requestBean.getMessage();
		sessionBean.getMessage();
		return "Welcome";
	}
}
