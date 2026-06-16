package com.betacom.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectJpaVeicoliApplication {
	
//	@Autowired
//	private ProcessJPA pro;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectJpaVeicoliApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//			pro.execute();
//		};
//	}
}
