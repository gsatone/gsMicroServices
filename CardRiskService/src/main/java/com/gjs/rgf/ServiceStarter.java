package com.gjs.rgf;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan(basePackages="com.gjs.rgf")
public class ServiceStarter extends SpringBootServletInitializer implements CommandLineRunner{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServiceStarter.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceStarter.class, args);
	}
/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Hello World from Application Runner");
		
	}
*/
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World from Command Line Runner");
		
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
		
	}
	
	
/*	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	*/
	
}
