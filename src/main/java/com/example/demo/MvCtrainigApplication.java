package com.example.demo;

import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class MvCtrainigApplication {
	@Bean
	public MultipartResolver multipartResolver(){
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		return resolver;
	}

	public void addResorceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	public static void main(String[] args) {
		SpringApplication.run(MvCtrainigApplication.class, args);
	}
}
