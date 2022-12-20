package pl.put.poznan.sorting.logic;


/**
 * HeapSort implementation.
 *
 */

public class HeapSort implements SortStrategy {

    int directionSwitch = 1;
    String sortKey;
    /**
     * Function to heapify a subtree rooted with node of i which is an index in arr[].
     * The method uses Comparator class to compare objects
     *
     * @param   array   data to sort (as an object)
     * @param   n       int, size of the heap
     * @param   i       int, index of the current largest element
     */
    void heapify(Object[] array, int n, int i) {

        Comparator comp = new Comparator(sortKey);

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n &&
                directionSwitch * comp.compareTo(array[left], (array[largest]) )> 0)
            largest = left;

        if (right < n &&
                directionSwitch * comp.compareTo(array[right], (array[largest]) ) > 0)
            largest = right;

        if (largest != i) {
            Object swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }


    @Override
    /**
     * Returns data sorted using HeapSort method.
     * The method uses Comparator class to compare objects
     * and overrides sort method from SortStrategy.
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of data sorted with HeapSort algorithm.
     */
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {

        directionSwitch = reverse ? -1 : 1;
        this.sortKey = sortKey;

        int n = data.length;
        int actualIteration = 0;
        boolean breakSort = (iterations > 0);

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);

        for (int i = n - 1; i >= 0; i--) {
            Object temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            if (breakSort && ++actualIteration >= iterations) {
                break;
            }

            heapify(data, i, 0);

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
        return "HeapSort";
    }
}
