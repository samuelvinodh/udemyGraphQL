package com.sam.graphql;

import com.sam.graphql.model.Car;
import com.sam.graphql.service.CarService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class MyGraphQlRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGraphQlRestApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarService carService){
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
						Car car = new Car();
						car.setName(name);
						carService.saveCar(car);
			});
			carService.getCars().forEach(System.out::println);
		};
	}

}
