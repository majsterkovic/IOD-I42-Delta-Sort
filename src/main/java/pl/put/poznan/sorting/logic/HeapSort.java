package pl.put.poznan.sorting.logic;

/**
 * Heap sort implementation.
 *
 */

public class HeapSort implements SortStrategy {

    /**
     * Function to heapify a subtree rooted with node i which is an index in arr[].
     * The method usues comparator class to compare objects with one another
     *
     * @param   array     data to sort (as an object)
     * @param   sortKey   string sorting key used by comparator
     * @param   n         size of the heap
     *
     */
    void heapify(Object[] array, int n, int i, String sortKey) {

        Comparator comp = new Comparator(sortKey);

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (  left < n &&
                comp.compareTo(array[left], (array[largest]) )> 0)
            largest = left;

        if (right < n &&
                comp.compareTo(array[right], (array[largest]) ) > 0)
            largest = right;

        if (largest != i) {
            Object swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest, sortKey);
        }
    }

    /**
     * Returns data sorted usunig heap sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param data      data to sort (as an object)
     * @param sortKey   string sorting key used by comparator
     * @return          data after heap sort sorting
     *
     */
    @Override
    public Object[] sort(Object[] data, String sortKey) {
        int n = data.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i, sortKey);

        for (int i = n - 1; i >= 0; i--) {
            Object temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i, 0, sortKey);
        }
        return data;
    }
}
