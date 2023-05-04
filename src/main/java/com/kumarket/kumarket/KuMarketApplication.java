package com.kumarket.kumarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KuMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuMarketApplication.class, args);
    }

}
