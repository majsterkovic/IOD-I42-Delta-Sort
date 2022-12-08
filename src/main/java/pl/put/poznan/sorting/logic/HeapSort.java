package pl.put.poznan.sorting.logic;

/**
 * Heap sort implementation.
 *
 */

public class HeapSort implements SortStrategy {

    void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    void heapify(String[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left].compareTo(array[largest]) > 0)
            largest = left;

        if (right < n && array[right].compareTo(array[largest]) > 0)
            largest = right;

        if (largest != i) {
            String swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    @Override
    public int[] sort(int[] data) {
        int n = data.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i, 0);
        }
        return data;
    }

    @Override
    public String[] sort(String[] data) {
        int n = data.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);

        for (int i = n - 1; i >= 0; i--) {
            String temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i, 0);
        }
        return data;
    }
}
