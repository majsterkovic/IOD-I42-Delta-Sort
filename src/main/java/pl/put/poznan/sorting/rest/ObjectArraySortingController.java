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
import com.google.gson.internal.LinkedTreeMap;

import pl.put.poznan.sorting.app.SortingMadness;
import pl.put.poznan.sorting.models.ObjectSortRequest;
import pl.put.poznan.sorting.models.SortResult;

import java.util.Map;

/**
 * Sorting controller rest implementation for objects.
 *
 */
@RestController
@RequestMapping("/api/objectarray")
public class ObjectArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(ObjectArraySortingController.class);

    /**
     * Post implementation.
     * Method updates the logger and after reading from JSON initializes sorting or
     * informs user about mistakes made while providing the data
     *
     * @param   requestData         type: Map
     * @return                      result of sorting
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody Map<String, Object> requestData) {

        logger.info("Received new request object.");

        ObjectSortRequest request;
        try {
            request = ObjectSortRequest.fromJson(requestData.toString());
        } catch (JsonSyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Wrong json syntax.\"}");
        }

        if (request.algorithms == null || request.algorithms.length == 0) {
            logger.error("No algorithm provided.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"No algorithm provided.\"}");
        }
        
        if (request.key == null || request.key.length() == 0) {
            logger.error("Key not specified.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Key not specified.\"}");
        }

        for (Object value : request.data) {
            logger.info(value.getClass().toString());
            if (!(value instanceof LinkedTreeMap)) {
                logger.error("Wrong type of data.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Wrong type of data.\"}");
            }
            LinkedTreeMap<String, Object> object = (LinkedTreeMap)value;
            if (object.containsKey(request.key) == false) {
                logger.error("Data don't contains key.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Data don't contains key.\"}");
            }
            if (!(object.get(request.key) instanceof String || object.get(request.key) instanceof Float || object.get(request.key) instanceof Double || object.get(request.key) instanceof Long || object.get(request.key) instanceof Integer)) {
                logger.error("Type of value to compare is not supported.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Type of value to compare is not supported.\"}");
            }
            if (object.get(request.key).getClass() != ((LinkedTreeMap<?, ?>)request.data[0]).get(request.key).getClass()) {
                logger.error("Data have different types.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Data have different types.\"}");
            }
        }

        if (request.data == null || request.data.length == 0) {
            logger.error("No data provided.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"No data provided.\"}");
        }

        logger.debug("Initializing sorter.");
        SortingMadness madness = new SortingMadness(request.data, request.algorithms, request.key, request.reverse, request.iterations);
        SortResult[] result = madness.getResult();
        
        logger.debug("Returning result.");
        return ResponseEntity.ok(result);
    }

}