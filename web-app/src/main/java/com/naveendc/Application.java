package com.naveendc;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by kumardc on 09/02/25
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.naveendc.controllers", "com.naveendc.bean","com.naveendc.service"})
@EnableAutoConfiguration
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(ChatClient.Builder builder) {
    return args -> {
      var chat = builder.build();

      ChatResponse response = chat.prompt("What is gemini-2.0-flash-001 model and provide details in 50 words only")
              .call()
              .chatResponse();

      System.out.println(response);

    };
  }
}