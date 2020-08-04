package com.nj.samples.tracing.serviceC;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ServiceCApplication {

	public static void main(String[] args) {
		log.trace("ServiceC started !!");
		SpringApplication.run(ServiceCApplication.class, args);
	}

}
