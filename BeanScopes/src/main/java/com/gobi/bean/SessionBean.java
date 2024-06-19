package com.gobi.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionBean {

	public SessionBean() {
		System.out.println("SessionBean Created!!");
	}
	
	public String getMessage() {
		return "SessionBean::getMessage method!!!";
	}
}
