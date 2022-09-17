package edu.lemon_school;

import edu.lemon_school.internetstore.config.YamlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(YamlConfig.class)
public class InternetstoreApplication {

	public static void main(String... args) {
		SpringApplication.run(InternetstoreApplication.class, args);
	}

}
