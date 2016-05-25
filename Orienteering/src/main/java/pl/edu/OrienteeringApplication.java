package pl.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@SpringBootApplication
public class OrienteeringApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
//		for(String s : args)
//			System.out.println(s);
//		new ClassPathXmlApplicationContext("context.xml");
		SpringApplication.run(OrienteeringApplication.class, args);
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		if (!registry.hasMappingForPattern("/assets/**")) {
//			registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
//		}
//	}
}
