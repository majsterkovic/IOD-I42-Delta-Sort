package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.app.SortingMadness;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/simplearray")
public class SimpleArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleArraySortingController.class);

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Map<String, Object> post(@RequestBody Map<String, Object> requestData)
            throws InvalidParameterException {

        logger.info("Received new request.");

        String data;
        String[] algorithms;
        int iterations = 0;
        String direction = "asc";

        logger.debug("Initializing sorter.");

        if (!requestData.containsKey("algorithms")) {
            logger.error("No algorithm provided.");
            throw new InvalidParameterException("No algorithm provided.");
        } else {
            algorithms = requestData.get("algorithms").toString().split(",");
        }

        if (requestData.containsKey("direction")) {
            direction = requestData.get("direction").toString();
        }

        if (requestData.containsKey("iterations")) {
            iterations = Integer.parseInt(requestData.get("iterations").toString());
        }

        if (!requestData.containsKey("data")) {
            logger.error("No data provided.");
            throw new InvalidParameterException("No data provided.");
        } else {
            data = requestData.get("data").toString();
        }

        SortingMadness madness = new SortingMadness(data, algorithms, direction, iterations);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", madness.getResult());
        return result;
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