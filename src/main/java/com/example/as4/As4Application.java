package com.example.as4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class As4Application {

	public static void main(String[] args) {
		SpringApplication.run(As4Application.class, args);
	}

}

/* help:
@Component - tells that objects of this class will be created by Spring(not User)
Repository works with Entity (Agent) - saves to database, gets from database
Controller works with DTO (AgentDTO) - gets requests from user, responses to user

logic for Create: JSON(http request) → DTO(@RequestBody) → Entity(for Repository) →
→ DB → Entity(DB returns updated Entity which is written to database(new component: id))→
→ DTO → JSON(returns to user)
 */

