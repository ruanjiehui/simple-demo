package com.rjh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class UnifiedResponseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedResponseDemoApplication.class, args);
	}
}
