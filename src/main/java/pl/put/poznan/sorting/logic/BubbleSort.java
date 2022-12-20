package pl.put.poznan.sorting.logic;


/**
 * BubbleSort implementation.
 */

public class BubbleSort implements SortStrategy {

    /**
     * Returns data sorted using BubbleSort method.
     * The method uses Comparator class to compare objects
     * and overrides sort method from SortStrategy.
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of data sorted with BubbleSort algorithm.
     */
    @Override

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        boolean breakSort = (iterations > 0);
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;


        Object temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < (data.length - i); j++) {

                if (directionSwitch * comp.compareTo(data[j - 1], (data[j])) > 0)
                {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
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
     * @return  name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "BubbleSort";
    }
}
