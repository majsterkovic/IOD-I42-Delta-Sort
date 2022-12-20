package pl.put.poznan.sorting.logic;
/**
 * Quick sort implementation.
 *
 */

public class QuickSort implements SortStrategy
{
    private Comparator comp;
    private int directionSwitch = 1;

    /**
     * Returns index of a pivot element.
     * Takes last element and uses it as a pivot -
     * places it in the right place in the array and places
     * all smaller elements before it and all the bigger elements
     * after it.
     * The method uses comparator class to compare objects with one another.
     *
     * @param   data    data to sort (as an object)
     * @param   low     starting index
     * @param   high    ending index
     * @return          index of a pivot element
     */
    int partition(Object[] data, int low, int high)
    {
        Object pivot = data[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            if (directionSwitch*comp.compareTo(data[j], pivot) <= 0)
            {
                i++;

                Object temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        Object temp = data[i+1];
        data[i+1] = data[high];
        data[high] = temp;

        return i+1;
    }

    /**
     * Sorts data using quick sort method.
     * Use recursion to sort data by dividing it according to pivot.
     *
     * @param   data    data to sort (as an object)
     * @param   low     starting index
     * @param   high    ending index
     * @param   limit   number of iterations to run
     */
    void quickSorting(Object[] data, int low, int high, int limit)
    {
        if (low < high && limit>0)
        {

            int pi = partition(data, low, high);

            quickSorting(data, low, pi-1, limit-1);
            quickSorting(data, pi+1, high, limit-1);
        }
    }

    /**
     * Returns data sorted using QuickSort method.
     * The method uses Comparator class to compare objects
     * and overrides sort method from SortStrategy.
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of data sorted with QuickSort algorithm.
     */
    @Override
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        comp = new Comparator(sortKey);
        directionSwitch = reverse ? -1 : 1;
        int temp2;
        if (iterations <= 0) {
            temp2 = Integer.MAX_VALUE;
        }
        else {
            temp2 = iterations;
        }
        int temp = data.length;
        quickSorting(data, 0, temp-1, temp2);

        return data;
    }

    /**
     * Get name of the sorting method.
     *
     * @return      name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "QuickSort";
    }
}
