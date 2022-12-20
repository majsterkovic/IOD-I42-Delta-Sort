package pl.put.poznan.sorting.logic;


/**
 * Bubble sort implementation.
 */

public class BubbleSort implements SortStrategy {

    /**
     * Returns data sorted usunig bubble sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data        data to sort (as an object)
     * @param   sortKey     string sorting key used by comparator
     * @param   iterations  int number of iterations to perform (if 0 -> perform whole sorting operation)
     * @param   reverse     boolean, used to determin sorting order
     * @return              data after bubble sort sorting
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
     * @return      String name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "BubbleSort";
    }
}
