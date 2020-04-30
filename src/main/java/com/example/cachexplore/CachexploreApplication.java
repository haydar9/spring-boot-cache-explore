package com.example.cachexplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachexploreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachexploreApplication.class, args);
	}

}
