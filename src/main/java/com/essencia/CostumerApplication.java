package com.essencia;

import com.essencia.config.FileStatorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({FileStatorageConfig.class})
@SpringBootApplication
public class CostumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostumerApplication.class, args);
	}

}

