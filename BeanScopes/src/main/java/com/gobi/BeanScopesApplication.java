package com.gobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gobi.bean.PrototypeBean;
import com.gobi.bean.SingletonBean;

@SpringBootApplication
public class BeanScopesApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to Bean Scope!!");
		/**
		 * 1. Singleton (Default)
		 * 2. Prototype
		 * 3. Request
		 * 4. Session
		 * 5. Application
		 * 6. Web Socket
		 */
		ConfigurableApplicationContext context = SpringApplication.run(BeanScopesApplication.class, args);
		
		SingletonBean singleton1 = context.getBean("singletonBean", SingletonBean.class);
		SingletonBean singleton2 = context.getBean("singletonBean", SingletonBean.class);
		SingletonBean singleton3 = context.getBean("singletonBean", SingletonBean.class);
		
		PrototypeBean prototype1 = context.getBean("prototypeBean", PrototypeBean.class);
		PrototypeBean prototype2 = context.getBean("prototypeBean", PrototypeBean.class);
		PrototypeBean prototype3 = context.getBean("prototypeBean", PrototypeBean.class);
		
		context.close();
	}

}
