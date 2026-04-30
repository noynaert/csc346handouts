package com.noynaert.thymeleaf1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafApplication {
    public static final String TITLE = "A picture of red creeeping thyme";
    public static final String PICTURE = "https://seedsworld.online/cdn/shop/files/red-creeping-thyme-seeds-vibrant-groundcover-or-non-gmo-11081.png?v=1774262278&width=220";
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

}
