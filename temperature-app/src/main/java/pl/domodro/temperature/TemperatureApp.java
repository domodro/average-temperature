package pl.domodro.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TemperatureApp {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureApp.class, args);
	}

}
