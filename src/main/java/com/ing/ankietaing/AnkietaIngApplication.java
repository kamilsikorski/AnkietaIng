package com.ing.ankietaing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class AnkietaIngApplication  {

    public static void main(String[] args) {
        SpringApplication.run(AnkietaIngApplication.class, args);
    }

    @Bean
    Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
