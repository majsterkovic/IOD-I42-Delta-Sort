package pl.put.poznan.sorting.logic;

/**
 * Dummy sort implementation for testing purposes only.
 * May be deleted after implementation of a real sorting algorithm.
 */
public class DummySort implements SortStrategy{

    @Override
    public int[] sort(int[] data) {
        return data;
    }

    @Override
    public String[] sort(String[] data) {
        return data;
    }
}
