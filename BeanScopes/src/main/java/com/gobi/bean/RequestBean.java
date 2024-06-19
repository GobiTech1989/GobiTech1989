package com.gobi.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RequestBean {

	public RequestBean() {
		System.out.println("RequestBean Created!!");
	}
	
	public String getMessage() {
		return "RequestBean::getMessage method!!!";
	}
}
