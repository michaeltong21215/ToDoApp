package com.practice.todoapp;

import com.practice.todoapp.model.AuditAwareImpl;
import com.practice.todoapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Slf4j
public class TodoappApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditAwareImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserService userService = applicationContext.getBean(UserService.class);
		log.info(userService.toString());
	}
}
