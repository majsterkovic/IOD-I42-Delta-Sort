package pl.put.poznan.sorting.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sorting application spring boot implementation
 *
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.sorting.rest"})
public class SortingApplication {

    /**
     * Main function to run the application with given arguments.
     *
     * @param   args    type: String[]
     */

    public static void main(String[] args) {
        SpringApplication.run(SortingApplication.class, args);
    }

}
