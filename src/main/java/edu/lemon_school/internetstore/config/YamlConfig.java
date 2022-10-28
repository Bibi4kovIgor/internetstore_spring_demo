package edu.lemon_school.internetstore.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Getter
@Setter
public class YamlConfig {
    private String name;
    private String environment;
    private String key;
    private boolean enabled;

    @Component
    public static class Config {

        private static YamlConfig YAML_CONFIG;

        public Config(YamlConfig yamlConfig) {
            YAML_CONFIG = yamlConfig;
        }

        public static String getKey(){
            return YAML_CONFIG.getKey();
        }
    }
}
