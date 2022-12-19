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
     * @param   data
     * @param   sortKey
     * @return  sort with strategy
     */
    public Object[] sort(Object[] data, String sortKey) {
        return strategy.sort(data, sortKey);
    }

}
