package com.newt.mytraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(=@ComponentScan+EnableAutoConfiguration+@Component)
public class MyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDemoApplication.class, args);
	}
	
	
	
}
