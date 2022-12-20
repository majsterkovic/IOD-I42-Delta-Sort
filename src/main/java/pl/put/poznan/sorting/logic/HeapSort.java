package pl.put.poznan.sorting.logic;


/**
 * Heap sort implementation.
 *
 */

public class HeapSort implements SortStrategy {

    int directionSwitch = 1;
    String sortKey;
    /**
     * Function to heapify a subtree rooted with node i which is an index in arr[].
     * The method usues comparator class to compare objects with one another
     *
     * @param   array   data to sort (as an object)
     * @param   i       int, index of the current largest element
     * @param   n       int, size of the heap
     *
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
     * Returns data sorted usunig heap sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data        data to sort (as an object)
     * @param   sortKey     string sorting key used by comparator
     * @param   iterations  int number of iterations to perform (if 0 -> perform whole sorting operation)
     * @param   reverse     boolean, used to determin sorting order
     * @return              data after heap sort sorting
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
     * @return      String name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "HeapSort";
    }
}
