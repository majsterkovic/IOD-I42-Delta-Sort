package pl.put.poznan.sorting.logic;

/**
 * Insertion sort implementation.
 *
 */

public class InsertionSort implements SortStrategy {

     /**
     * Returns data sorted usunig insertion sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data      data to sort (as an object)
     * @param   sortKey   string sorting key used by comparator
     * @return            data after insertion sort sorting
     */
    @Override
    public Object[] sort(Object[] data, String sortKey) {
        Comparator comp = new Comparator(sortKey);
        int n = data.length;
        for (int i = 1; i < n; i++) {
            Object key = data[i];
            int j = i - 1;
            while (j >= 0 && comp.compareTo(data[j], key) > 0) {
                data[j+1] = data[j];
                j = j -1;
            }
            data[j+1] = key;
        }
        return data;
    }
}
