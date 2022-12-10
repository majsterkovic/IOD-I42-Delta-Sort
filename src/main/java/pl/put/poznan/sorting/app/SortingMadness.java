package pl.put.poznan.sorting.app;

import pl.put.poznan.sorting.logic.SortContext;
import pl.put.poznan.sorting.logic.SortingWrapper;

import java.util.HashMap;
import java.util.Map;

public class SortingMadness {

    private final String data;
    private final String[] algorithms;
    private final String direction;
    private final int iterations;
    private final Object[] input;

    private final static SortingWrapper wrapper = new SortingWrapper();


    public SortingMadness(String data, String[] algorithms, String direction, int iterations) {
        this.data = data;
        this.algorithms = algorithms;
        this.direction = direction;
        this.iterations = iterations;

        this.input = convertData(data);
    }

    public Object[] convertData(String data) {

        String[] input = data.split(",");
        // remove [ ] from the first and last element

        input[0] = input[0].substring(1);
        input[input.length - 1] = input[input.length - 1].substring(0, input[input.length - 1].length() - 1);


        Object[] in = new Object[input.length];

        // If input is string
        if (data.matches(".*[a-z|A-Z]+.*")) {
            in = input;
        }

        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }

        // If input is Float
        if (data.contains(".")) {
            for (int i = 0; i < input.length; i++) in[i] = Float.parseFloat(input[i]);
        }
        // If input is Integer
        else {
            for (int i = 0; i < input.length; i++) in[i] = Integer.parseInt(input[i]);
        }

        // TODO: if input is Object!!

        return in;
    }

    public Map<String, Object> getResult() {

        Map<String, Object> results = new HashMap<>();
        Object[] result = new Object[input.length];
        for (String algorithm : algorithms) {
            algorithm = algorithm.trim();
            SortContext context = new SortContext(wrapper.getSorter(algorithm));
            result = context.sort(input);
            results.put(algorithm, result);
        }

        return results;
    }
}
