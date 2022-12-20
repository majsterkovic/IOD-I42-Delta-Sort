package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.JsonSyntaxException;

import pl.put.poznan.sorting.app.SortingMadness;
import pl.put.poznan.sorting.models.SortRequest;
import pl.put.poznan.sorting.models.SortResult;

import java.util.HashMap;
import java.util.Map;
/**
 * Request to sort object JSON implementation for simple arrays.
 *
 */
@RestController
@RequestMapping("/api/simplearray")
public class SimpleArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleArraySortingController.class);
    /**
     * Post implementation.
     * Method updates the logger and after reading from JSON initializes sorting or
     * informs user about mistakes made while providing the data.
     *
     * @param   requestData requested data
     * @return  result of sorting
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody Map<String, Object> requestData) {

        logger.info("Received new request.");

        SortRequest request;
        try {
            request = SortRequest.fromJson(requestData.toString());
        } catch (JsonSyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (request.data == null || request.data.length == 0) {
            logger.error("No data provided.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No data provided.");
        }

        for (Object value : request.data) {
            if (value.getClass() != request.data[0].getClass()) {
                logger.error("Data have different types.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data have different types.");
            }
        }

        if (request.algorithms == null || request.algorithms.length == 0) {
            logger.error("No algorithm provided.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No algorithm provided.");
        }

        logger.debug("Initializing sorter.");

        SortingMadness madness = new SortingMadness(request.data, request.algorithms, request.reverse, request.iterations);
        SortResult[] result = madness.getResult();

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{algorithms}/{reverse}/{iterations}", consumes = "application/json", produces = "application/json")
    public Map<String, Object> get(@PathVariable("algorithms") String[] algorithms,
                                   @PathVariable("reverse") boolean reverse,
                                   @PathVariable("iterations") int iterations,
                                   @RequestParam("data") Object[] data) {

        System.out.println("Received new request.");
        SortingMadness madness = new SortingMadness(data, algorithms, reverse, iterations);
        Map<String, Object> result = new HashMap<>();
        result.put("result", madness.getResult());
        return result;
    }

}