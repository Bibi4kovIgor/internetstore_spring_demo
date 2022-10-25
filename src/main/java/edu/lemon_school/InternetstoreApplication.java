package edu.lemon_school;

import edu.lemon_school.internetstore.config.YamlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAsync(proxyTargetClass = true)
@EnableConfigurationProperties(YamlConfig.class)
public class InternetstoreApplication {

	public static void main(String... args) {
		SpringApplication.run(InternetstoreApplication.class, args);
	}

}
