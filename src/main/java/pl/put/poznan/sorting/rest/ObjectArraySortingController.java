package pl.put.poznan.sorting.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.sorting.app.HandleJSON;
import pl.put.poznan.sorting.app.SortingMadness;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/objectarray")
public class ObjectArraySortingController {

    private static final Logger logger = LoggerFactory.getLogger(ObjectArraySortingController.class);

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Map<String, Object> get(@RequestBody Map<String, Object> requestData)
            throws InvalidParameterException {

        logger.info("Received new request object.");

        JSONObject jsonObject = new JSONObject(requestData);
        JSONArray algorithmsJson;
        JSONArray dataJson;

        if (!jsonObject.has("data")) {
            logger.error("No data provided.");
            throw new InvalidParameterException("No data provided.");
        } else {
            dataJson = jsonObject.getJSONArray("data");
        }

        if (!jsonObject.has("algorithms")) {
            logger.error("No algorithm provided.");
            throw new InvalidParameterException("No algorithm provided.");
        } else {
            algorithmsJson = jsonObject.getJSONArray("algorithms");
        }

        String[] algorithms = HandleJSON.JSONArrayToStringArray(algorithmsJson);

        String direction = "asc";
        int iterations = 0;
        String key = null;

        if (jsonObject.has("direction")) {
            direction = jsonObject.get("direction").toString();
        }

        if (jsonObject.has("iterations")) {
            iterations = Integer.parseInt(jsonObject.get("iterations").toString());
        }

        if (jsonObject.has("key")) {
            key = jsonObject.get("key").toString();
        }

        logger.debug("Initializing sorter.");

        SortingMadness madness = new SortingMadness(dataJson, algorithms, direction, iterations, key);
        Map<String, Object> sortingResult = new HashMap<>();

        sortingResult.put("result", madness.getResult());
        return sortingResult;
    }

}