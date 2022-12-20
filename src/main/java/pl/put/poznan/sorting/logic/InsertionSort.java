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
     * @param   data        data to sort (as an object)
     * @param   sortKey     string sorting key used by comparator
     * @param   iterations  int number of iterations to perform (if 0 -> perform whole sorting operation)
     * @param   reverse     boolean, used to determin sorting order
     * @return              data after insertion sort sorting
     */
    @Override
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;
        boolean breakSort = (iterations > 0);

        int n = data.length;
        for (int i = 1; i < n; i++) {
            Object key = data[i];
            int j = i - 1;
            while (j >= 0 && directionSwitch * comp.compareTo(data[j], key) > 0) {
                data[j+1] = data[j];
                j = j -1;
            }
            data[j+1] = key;

            if (breakSort && ++actualIteration >= iterations) {
                break;
            }
        }
        return data;
    }

    /**
     * Get name of the sorting method.
     *
     * @return      String name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "InsertionSort";
    }
}