package pl.put.poznan.sorting.app;

import pl.put.poznan.sorting.logic.SortContext;
import pl.put.poznan.sorting.logic.SortingWrapper;
import pl.put.poznan.sorting.models.SortResult;

import java.util.ArrayList;

import pl.put.poznan.sorting.logic.Timer;

public class SortingMadness {

    private final String[] algorithms;
    private final boolean reverse;
    private final int iterations;
    private final Object[] input;
    private final String key;

    private final static SortingWrapper wrapper = new SortingWrapper();


    public SortingMadness(Object[] data, String[] algorithms, boolean reverse, int iterations) {

        this.algorithms = algorithms;
        this.reverse = reverse;
        this.iterations = iterations;
        this.key = null;
        this.input = data;
    }

    public SortingMadness(Object[] data, String[] algorithms, String key, boolean reverse, int iterations) {

        this.algorithms = algorithms;
        this.reverse = reverse;
        this.iterations = iterations;
        this.key = key;
        this.input = data;
    }

    public SortResult[] getResult() {

        ArrayList<SortResult> results = new ArrayList<SortResult>();

        for (String algorithm : algorithms) {
            SortContext context = new SortContext(wrapper.getSorter(algorithm));
            Timer timer = new Timer();
            timer.startMeasure();
            Object[] sortedData = context.sort(input, key, iterations);
            timer.stopMeasure();

            String time = timer.getElapsedTime("s");
            
            results.add(new SortResult(algorithm, time, sortedData));

        }
        return results.toArray(new SortResult[0]);
    }
}
