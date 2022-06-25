package maven.prac;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages= {"maven.prac"})
public class config {
	@Bean
	public Airtel getobj() {
		return new Airtel();
	}
	
}
