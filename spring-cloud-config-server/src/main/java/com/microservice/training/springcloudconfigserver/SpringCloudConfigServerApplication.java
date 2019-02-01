package com.microservice.training.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);


		int arr = [];
		Set<Integer> numbers = new TreeSet<Integer>(Arrays.asList(arr));

		int min = 1;
		for(int num : numbers) {
			if(min < num){
				return min;
			}
			min++;
		}
	}

}

