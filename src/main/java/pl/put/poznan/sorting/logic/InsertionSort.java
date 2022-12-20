package pl.put.poznan.sorting.logic;

/**
 * InsertionSort implementation.
 *
 */

public class InsertionSort implements SortStrategy {

    /**
     * Returns data sorted using InsertionSort method.
     * The method uses Comparator class to compare objects
     * and overrides sort method from SortStrategy.
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of data sorted with InsertionSort algorithm.
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
     * @return      name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "InsertionSort";
    }
}