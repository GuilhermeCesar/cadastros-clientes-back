package com.essencia.config;

import com.essencia.model.Customer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackageClasses = Customer.class)
public class ServiceConfig {
}
