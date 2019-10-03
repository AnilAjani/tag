package org.improving.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.AbstractDocument;
import java.util.Random;
import java.util.Scanner;

@Configuration
@ComponentScan("org.improving.tag")

public class SpringContext {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
    @Bean
    public Random getRandom(){
        return new Random();

    }
}
