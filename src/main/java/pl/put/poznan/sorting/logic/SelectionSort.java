package pl.put.poznan.sorting.logic;

/**
 * Selection sort implementation.
 */

public class SelectionSort implements SortStrategy {
    /**
     * Returns data sorted using SelectionSort method.
     * The method uses Comparator class to compare objects
     * and overrides sort method from SortStrategy.
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of data sorted with SelectionSort algorithm.
     */
    @Override

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;
        boolean breakSort = (iterations > 0);

        for (int i = 0; i < data.length - 1; i++) {
            int jMin = i;

            for (int j = i + 1; j < data.length; j++) {
                if (directionSwitch * comp.compareTo(data[j], (data[jMin])) < 0) {
                    jMin = j;
                }
            }

            if (jMin != i) {
                Object temp = data[i];
                data[i] = data[jMin];
                data[jMin] = temp;
            }

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
        return "SelectionSort";
    }
}
