package com.demo.job.elastic2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:jobs.xml")
@SpringBootApplication
public class ElasticJob2App {

	public static void main(String[] args) {
		SpringApplication.run(ElasticJob2App.class, args);
	}

}
