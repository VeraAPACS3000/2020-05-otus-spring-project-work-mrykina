package ru.otus.spring.FinancialDistribution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.spring.FinancialDistribution.configuration.PropsSettings;


@SpringBootApplication
@EnableConfigurationProperties({PropsSettings.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
