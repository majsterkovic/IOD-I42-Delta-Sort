package pl.put.poznan.sorting.logic;

/**
 * Sorting strategy.
 */
public interface SortStrategy {

    public Object[] sort(Object[] input, String key);

}