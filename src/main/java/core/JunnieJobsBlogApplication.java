package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan("blog")
@SpringBootApplication
public class JunnieJobsBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunnieJobsBlogApplication.class, args);
	}
	
}
