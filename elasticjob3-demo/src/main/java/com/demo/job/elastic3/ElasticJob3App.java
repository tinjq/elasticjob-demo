package com.demo.job.elastic3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:jobs.xml")
@SpringBootApplication
public class ElasticJob3App {

	public static void main(String[] args) {
		SpringApplication.run(ElasticJob3App.class, args);
	}

}
