package guru.springframework.sdjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SdjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjpaApplication.class, args);
	}

}
