package pl.put.poznan.sorting.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.put.poznan.sorting.logic.SortContext;
import pl.put.poznan.sorting.logic.SortingWrapper;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.*;
import pl.put.poznan.sorting.logic.Timer;

public class SortingMadness {

    private final String[] algorithms;
    private final String direction;
    private final int iterations;
    private final Object[] input;
    private final String key;

    private final static SortingWrapper wrapper = new SortingWrapper();


    public SortingMadness(String data, String[] algorithms, String direction, int iterations) {

        this.algorithms = algorithms;
        this.direction = direction;
        this.iterations = iterations;
        this.key = null;
        this.input = convertData(data);
    }

    public SortingMadness(JSONArray data, String[] algorithms, String direction, int iterations, String key) {

        this.algorithms = algorithms;
        this.direction = direction;
        this.iterations = iterations;
        this.key = key;
        this.input = convertData(data);
    }

    public Object[] convertData(JSONArray data) {

        Object[] in = new Object[data.length()];
        for (int i = 0; i < data.length(); i++) {
            JSONObject object = data.getJSONObject(i);
            in[i] = object;
        }
        return in;
    }

    public Object[] convertData(String data) {

        String[] input = data.split(",");

        input[0] = input[0].replace("[", "");
        input[input.length - 1] = input[input.length - 1].replace("]", "");

        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }

        Object[] in = new Object[input.length];

        if (data.matches(".*[a-z|A-Z]+.*")) {
            in = input;
        }

        else if (data.contains(".")) {
            for (int i = 0; i < input.length; i++) in[i] = Float.parseFloat(input[i]);
        }

        else {
            for (int i = 0; i < input.length; i++) in[i] = Integer.parseInt(input[i]);
        }
        return in;

    }

    public Map<String, Object> getResult() {

        Map<String, Object> results = new HashMap<>();
        Object[] result;

        boolean reverse = direction.equals("desc");

        for (String algorithm : algorithms) {

            algorithm = algorithm.trim();
            SortContext context = new SortContext(wrapper.getSorter(algorithm));

            Timer timer = new Timer();
            timer.startMeasure();

            result = context.sort(input, key, iterations);


            timer.stopMeasure();
            String executionTime = timer.getElapsedTime("s");

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            for (int i = 0; i < result.length; i++) {
                try {
                    result[i] = mapper.readValue(result[i].toString(), Object.class);
                } catch (JsonProcessingException e) {
                    // pass
                }
            }
            results.put(algorithm, result);

        }
        return results;
    }
}
