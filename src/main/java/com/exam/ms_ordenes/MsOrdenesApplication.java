package com.exam.ms_ordenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.exam.ms_ordenes")
public class MsOrdenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOrdenesApplication.class, args);
	}

}
