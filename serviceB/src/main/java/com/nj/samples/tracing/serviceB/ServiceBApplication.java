package com.nj.samples.tracing.serviceB;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ServiceBApplication {

	public static void main(String[] args) {
		log.info("Entering Service B!");
		SpringApplication.run(ServiceBApplication.class, args);
	}

}
