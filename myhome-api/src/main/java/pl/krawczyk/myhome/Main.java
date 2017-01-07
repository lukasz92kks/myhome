package pl.krawczyk.myhome;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 *
 * @author Łukasz
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Main {
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
