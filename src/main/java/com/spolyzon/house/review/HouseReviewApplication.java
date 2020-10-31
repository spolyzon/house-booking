package com.spolyzon.house.review;

import com.spolyzon.house.review.domain.model.Unit;
import com.spolyzon.house.review.domain.model.User;
import com.spolyzon.house.review.domain.repository.UnitRepository;
import com.spolyzon.house.review.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HouseReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseReviewApplication.class, args);
	}

	@Bean
	CommandLineRunner init (UnitRepository unitRepository, UserRepository userRepository) {
		return x -> {
			Unit unit = new Unit("title 1", "region1", 10);
			Unit unit2 = new Unit("title 1", "region1", 10, "This is a description");
			unitRepository.save(unit);
			unitRepository.save(unit2);

			User user = new User("admin", "admin");
			User user2 = new User("username", "password");
			userRepository.save(user);
			userRepository.save(user2);
		};
	}

}
