package pl.put.poznan.sorting.logic;

/**
 * Sorting Context implementation.
 *
 */

public class SortContext {

    private final SortStrategy strategy;
    /**
     * Method to asaign strategy
     *
     * @param   strategy    type: SortStrategy
     */
    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Method to sort using a strategy
     *
     * @param   data    type: Object[]
     * @param   sortKey type: String
     * @return          sort with strategy
     */
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        return strategy.sort(data, sortKey, iterations, reverse);

    }

}
