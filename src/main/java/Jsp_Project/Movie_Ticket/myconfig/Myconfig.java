package Jsp_Project.Movie_Ticket.myconfig;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {
	@Bean
	SecureRandom random() {
		return new SecureRandom();
	}

}
