package com.example.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.repository.UserRepository;

@SpringBootApplication
//@SpringBootApplication(exclude={EmbeddedMongoAutoConfiguration.class})
public class Lab5Application /*implements CommandLineRunner*/{

	//@Autowired
  	//private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Lab5Application.class, args);
	}

	/*@Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    // save a couple of customers
    repository.save(new UserEntity("user1", "123"));
    repository.save(new UserEntity("user2", "456"));

    // fetch all customers
    System.out.println("Users found with findAll():");
    System.out.println("-------------------------------");
    for (UserEntity u : repository.findAll()) {
      System.out.println(u.getUsername());
    }
    System.out.println();

    // fetch an individual customer
    System.out.println("Customer found with findByFirstName('Alice'):");
    System.out.println("--------------------------------");
    System.out.println(repository.findByUsername("Alice"));

    

  }
*/
}
