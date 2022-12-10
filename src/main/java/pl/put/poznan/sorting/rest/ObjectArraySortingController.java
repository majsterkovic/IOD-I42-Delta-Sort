package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.sorting.app.SortingMadness;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/objectarray")
public class ObjectArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(ObjectArraySortingController.class);


    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Map<String, Object> get(@RequestBody Map<String, Object> requestData)
            throws InvalidParameterException {

        logger.info("Received new request object.");

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

        // TODO: maybye use another class for this?
        SortingMadness madness = new SortingMadness(data, algorithms, direction, iterations);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", madness.getResult());
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    void post(@RequestBody Map<String, Object> data) {

        // TODO: implement POST
    }

}