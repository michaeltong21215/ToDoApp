package com.practice.todoapp;

import com.practice.todoapp.model.AuditAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class TodoappApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditAwareImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

}
