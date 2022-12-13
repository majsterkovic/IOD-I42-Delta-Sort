package pl.put.poznan.sorting.logic;


/**
 * Heap sort implementation.
 *
 */

public class HeapSort implements SortStrategy {

    int directionSwitch = 1;
    String sortKey;

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

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean ascending) {

        directionSwitch = ascending ? 1 : -1;
        this.sortKey = sortKey;

        int n = data.length;
        int actualIteration = 0;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);

        for (int i = n - 1; i >= 0; i--) {
            Object temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            actualIteration++;
            if (actualIteration >= iterations) {
                break;
            }

            heapify(data, i, 0);

        }
        return data;
    }

    @Override
    public String getName() {
        return "HeapSort";
    }
}
