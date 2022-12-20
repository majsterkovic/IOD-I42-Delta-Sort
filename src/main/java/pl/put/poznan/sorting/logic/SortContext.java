package pl.put.poznan.sorting.logic;

/**
 * Sorting Context implementation.
 *
 */

public class SortContext {

    private final SortStrategy strategy;
    /**
     * Method to assign strategy
     *
     * @param   strategy    type: SortStrategy
     */
    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Method to sort using a strategy
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of sorted data
     */
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        return strategy.sort(data, sortKey, iterations, reverse);

    }

}
