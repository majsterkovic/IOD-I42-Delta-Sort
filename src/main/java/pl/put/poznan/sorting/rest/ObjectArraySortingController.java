package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonSyntaxException;

import pl.put.poznan.sorting.app.SortingMadness;
import pl.put.poznan.sorting.models.SortRequest;
import pl.put.poznan.sorting.models.SortResult;

import java.util.Map;


@RestController
@RequestMapping("/api/objectarray")
public class ObjectArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(ObjectArraySortingController.class);

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> get(@RequestBody Map<String, Object> requestData) {

        logger.info("Received new request object.");

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

        logger.debug("Initializing sorter.");

        SortingMadness madness = new SortingMadness(request.data, request.algorithms, "key", request.reverse, request.iterations);
        SortResult[] result = madness.getResult();
        
        return ResponseEntity.ok(result);
    }

}