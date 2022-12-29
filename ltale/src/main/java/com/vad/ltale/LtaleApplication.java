package com.vad.ltale;

import com.vad.ltale.service.FileStorage;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LtaleApplication {

	@Resource
	FileStorage storageService;

	public static void main(String[] args) {
		SpringApplication.run(LtaleApplication.class, args);
	}

}
