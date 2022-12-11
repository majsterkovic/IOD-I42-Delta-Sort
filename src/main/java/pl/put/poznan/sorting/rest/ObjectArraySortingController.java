package pl.put.poznan.sorting.rest;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
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


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Map<String, Object> get(@RequestBody Map<String, Object> requestData)
            throws InvalidParameterException {

        logger.info("Received new request object.");

        JSONArray data;
        String[] algorithms;
        String key;
        int iterations = 0;
        String direction = "asc";


        logger.debug("Initializing sorter.");

        JSONObject jsonObject = new JSONObject(requestData);

        algorithms = jsonObject.get("algorithms").toString().split(",");
        direction = jsonObject.get("direction").toString();
        key = jsonObject.get("key").toString();
        //iterations = Integer.parseInt(jsonObject.get("iterations").toString());

        data = jsonObject.getJSONArray("data");

        SortingMadness madness = new SortingMadness(data, algorithms, direction, iterations, key);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", madness.getResult());
        return result;

    }

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    void post(@RequestBody Map<String, Object> data) {

        // TODO: implement POST
    }

}