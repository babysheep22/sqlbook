package com.example.rebook;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.io.File;

@EnableJpaAuditing //날짜 자동 생성
@SpringBootApplication
public class RebookApplication {



	public static void main(String[] args) {
		SpringApplication.run(RebookApplication.class, args);
	}

	

}
