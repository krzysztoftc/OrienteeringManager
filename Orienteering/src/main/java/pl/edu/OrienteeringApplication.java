package pl.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class OrienteeringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrienteeringApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
