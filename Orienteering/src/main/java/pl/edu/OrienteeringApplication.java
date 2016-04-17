package pl.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class OrienteeringApplication {

	public static void main(String[] args) {
//		for(String s : args)
//			System.out.println(s);
//		new ClassPathXmlApplicationContext("context.xml");
		SpringApplication.run(OrienteeringApplication.class, args);
	}
}
