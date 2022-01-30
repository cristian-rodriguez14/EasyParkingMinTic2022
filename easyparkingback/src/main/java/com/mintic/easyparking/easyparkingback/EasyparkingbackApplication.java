package com.mintic.easyparking.easyparkingback;

import com.mintic.easyparking.easyparkingback.security.AppProperties;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class EasyparkingbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyparkingbackApplication.class, args);
        System.out.print("It's Working\n");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean(name = "AppProperties")
    public AppProperties getAppProperties() {
        return new AppProperties();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
