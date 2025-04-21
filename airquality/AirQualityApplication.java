package br.com.fiap.airquality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AirQualityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirQualityApplication.class, args);
	}

}
