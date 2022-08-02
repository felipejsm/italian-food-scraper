package com.nssp.itfoodscraper;

import com.nssp.itfoodscraper.usecase.ExtractCardSectionFromHtml;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItfoodscraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItfoodscraperApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ExtractCardSectionFromHtml executeExtraction) {
        return args -> {
            var recipes = executeExtraction.getRecipes("https://foodnetwork.co.uk/italian-family-dinners/");
           // var recipes = executeExtraction.getRecipes("https://foodnetwork.co.uk/recipes/linguine-alla-parmigiana/");
            System.out.println(recipes);
        };
    }
}
