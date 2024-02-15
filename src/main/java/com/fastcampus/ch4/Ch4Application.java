package com.fastcampus.ch4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Ch4Application implements CommandLineRunner {

	@Autowired
	EntityManagerFactory emf;

	public static void main(String[] args) {
//		SpringApplication.run(Ch4Application.class, args);
		SpringApplication app = new SpringApplication(Ch4Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		EntityManager em = emf.createEntityManager();
		System.out.println("em = " + em);

		User user = new User();
		user.setId("aaa");
		user.setPassword("1234");
		user.setName("Lee");
		user.setInDate(new Date());
		user.setUpDate(new Date());
		em.persist(user); // user엔티티를 em에 영속화(저장)
	}
}
