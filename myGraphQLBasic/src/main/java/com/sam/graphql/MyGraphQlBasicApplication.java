package com.sam.graphql;

import com.sam.graphql.repos.SuperCharacterRepo;
import com.sam.graphql.resolvers.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyGraphQlBasicApplication {

	/*@Autowired
	SuperCharacterRepo superCharacterRepo;

	@Bean
	public Query query(){
		return new Query(superCharacterRepo);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(MyGraphQlBasicApplication.class, args);
	}

}
