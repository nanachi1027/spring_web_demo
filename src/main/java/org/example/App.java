package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:10 上午
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.example.repo"})
@EntityScan(basePackages = {"org.example.model"})
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        new SpringApplication(App.class).run(args);
    }
}
