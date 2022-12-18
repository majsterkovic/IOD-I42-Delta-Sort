package pl.put.poznan.sorting.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sorting application spring boot implementation
 *
 */

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.sorting.rest"})
public class SortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortingApplication.class, args);
    }

}
