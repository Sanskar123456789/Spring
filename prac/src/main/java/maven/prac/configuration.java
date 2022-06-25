package maven.prac;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages= {"maven.prac"})
public class configuration {
	@Bean
	public Airtel getobj() {
		return new Airtel();
	}
	
	@Bean
	public idea getobj1() {
		return new idea();
	}
}

