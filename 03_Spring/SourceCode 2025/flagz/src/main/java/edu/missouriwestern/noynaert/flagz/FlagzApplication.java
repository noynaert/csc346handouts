package edu.missouriwestern.noynaert.flagz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlagzApplication {

    static Flagdb db = new Flagdb();

    public static void main(String[] args) {
        db.insert(new Flag("mo.jpg","Missouri"));
        db.insert(new Flag());
        db.insert(new Flag("tx.jpg", "Texas"));
        db.insert(new Flag("iowa.jpg", "Iowa"));

        SpringApplication.run(FlagzApplication.class, args);
    }

}
