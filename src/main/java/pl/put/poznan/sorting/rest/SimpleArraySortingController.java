package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.JsonSyntaxException;

import pl.put.poznan.sorting.app.SortingMadness;
import pl.put.poznan.sorting.models.SortRequest;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/simplearray")
public class SimpleArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleArraySortingController.class);

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody Map<String, Object> requestData)
            throws InvalidParameterException {

        logger.info("Received new request.");

        String direction = "asc";

        logger.debug("Initializing sorter.");

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

        if (request.algorithms == null || request.algorithms.length == 0) {
            logger.error("No algorithm provided.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No algorithm provided.");
        }

        SortingMadness madness = new SortingMadness(
            request.data, request.algorithms, direction, request.iterations
        );

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", madness.getResult());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{algorithms}/{direction}/{iterations}", consumes = "application/json", produces = "application/json")
    public Map<String, Object> get(@PathVariable("algorithms") String[] algorithms,
                                   @PathVariable("direction") String direction,
                                   @PathVariable("iterations") int iterations,
                                   @RequestParam("data") String data) {

        System.out.println("Received new request.");
        SortingMadness madness = new SortingMadness(data, algorithms, direction, iterations);
        Map<String, Object> result = new HashMap<>();
        result.put("result", madness.getResult());
        return result;
    }


}