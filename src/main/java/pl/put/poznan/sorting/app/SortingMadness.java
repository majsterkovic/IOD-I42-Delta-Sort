package pl.put.poznan.sorting.app;

import pl.put.poznan.sorting.logic.AutoSortSelect;
import pl.put.poznan.sorting.logic.SortContext;
import pl.put.poznan.sorting.logic.SortingWrapper;
import pl.put.poznan.sorting.models.SortResult;

import java.util.ArrayList;

import pl.put.poznan.sorting.logic.Timer;

/**
 * Sorting application implementation.
 *
 */

public class SortingMadness {

    private final String[] algorithms;
    private final boolean reverse;
    private final int iterations;
    private final Object[] input;
    private final String key;

    private final static SortingWrapper wrapper = new SortingWrapper();

    /**
     * Assigning given parameters to class fields.
     *
     * @param   data        type: Object[]
     * @param   algorithms  type: String[]
     * @param   reverse     type: boolean, to establish sorting order
     * @param   iterations  type: int, to establish how many iterations to run
     */
    public SortingMadness(Object[] data, String[] algorithms, boolean reverse, int iterations) {

        this.algorithms = algorithms;
        this.reverse = reverse;
        this.iterations = iterations;
        this.key = null;
        this.input = data;
    }


    /**
     * Assigning given parameters to class fields.
     *
     * @param   data        type: Object[]
     * @param   algorithms  type: String[]
     * @param   key         type: String, to establish sorting key
     * @param   reverse     type: boolean, to establish sorting order
     * @param   iterations  type: int, to establish how many iterations to run
     */

    public SortingMadness(Object[] data, String[] algorithms, String key, boolean reverse, int iterations) {

        this.algorithms = algorithms;
        this.reverse = reverse;
        this.iterations = iterations;
        this.key = key;
        this.input = data;
    }

    /**
     * Getting sorting result.
     * Method returns sorted data in the appropriate format.
     *
     * @return      sorted data
     */
    public SortResult[] getResult() {

        ArrayList<SortResult> results = new ArrayList<>();

        for (String algorithm : algorithms) {
            SortContext context;
            String sortMethod;

            if (algorithm.compareTo("auto") == 0) { 
                sortMethod = AutoSortSelect.GetSortingAlgorithm(input, key);
            }
            else { 
                sortMethod = algorithm; 
            }
            context = new SortContext(wrapper.getSorter(sortMethod));
            Timer timer = new Timer();
            timer.startMeasure();
            Object[] sortedData = context.sort(input, key, iterations, reverse);
            timer.stopMeasure();

            String time = timer.getElapsedTime("s");
            
            results.add(new SortResult(sortMethod, time, sortedData));

        }
        return results.toArray(new SortResult[0]);
    }
}
