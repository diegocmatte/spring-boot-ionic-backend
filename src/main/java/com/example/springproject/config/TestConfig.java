package com.example.springproject.config;

import com.example.springproject.services.DBService;
import com.example.springproject.services.EmailService;
import com.example.springproject.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDataBase() throws ParseException {

        dbService.instantiateDataBase();

        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
