package pl.put.poznan.sorting.logic;

/**
 * Heap sort implementation.
 *
 */

public class HeapSort implements SortStrategy {

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
