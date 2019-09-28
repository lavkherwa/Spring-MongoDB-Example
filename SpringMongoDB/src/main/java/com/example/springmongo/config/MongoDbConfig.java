package com.example.springmongo.config;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.springmongo.model.User;
import com.example.springmongo.repository.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoDbConfig {

	/* We will use command line runner to inject some documents at startup */
	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> {
			Optional<User> user1 = userRepository.findById(1);
			if (user1.isPresent() == false) {
				userRepository.save(new User(1, "Lav", 10000000));
			}
			Optional<User> user2 = userRepository.findById(2);
			if (user2.isPresent() == false) {
				userRepository.save(new User(2, "Kush", 10000000));
			}
		};
	}
}
