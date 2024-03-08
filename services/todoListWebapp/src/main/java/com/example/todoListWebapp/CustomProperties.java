package com.example.todoListWebapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.example.todolistwebapp")
public class CustomProperties {
	
	private String apiUrl;

}
