package com.nssp.itfoodscraper;

import com.nssp.itfoodscraper.usecase.ExtractCardSectionFromHtml;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItfoodscraperApplication {
    private static final String URL = "https://foodnetwork.co.uk/italian-family-dinners/";
    public static void main(String[] args) {
        SpringApplication.run(ItfoodscraperApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ExtractCardSectionFromHtml executeExtraction) {
        return args -> {
            var recipes = executeExtraction.getRecipes(URL);
            System.out.println(recipes);
        };
    }
}
