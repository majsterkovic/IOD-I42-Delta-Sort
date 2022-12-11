package pl.put.poznan.sorting.logic;

import java.util.ArrayList;

/**
 * Sorting strategy.
 */
public interface SortStrategy {

    public Object[] sort(Object[] input, String key);

}