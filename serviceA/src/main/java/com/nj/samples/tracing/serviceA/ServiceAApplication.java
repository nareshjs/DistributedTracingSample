package com.nj.samples.tracing.serviceA;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ServiceAApplication {

	public static void main(String[] args) {
		log.info("Entering Service A");
		SpringApplication.run(ServiceAApplication.class, args);
	}

}
