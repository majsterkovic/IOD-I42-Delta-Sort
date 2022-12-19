package pl.put.poznan.sorting.logic;

/**
 * Sorting strategy.
 */
public interface SortStrategy {

    Object[] sort(Object[] input, String key, int iterations, boolean reverse);

    String getName();

}