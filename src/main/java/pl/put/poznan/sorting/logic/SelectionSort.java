package pl.put.poznan.sorting.logic;

/**
 * Selection sort implementation.
 */

public class SelectionSort implements SortStrategy {

    @Override
    public Object[] sort(Object[] data, String sortKey) {
        Comparator comp = new Comparator(sortKey);
        for (int i = 0; i < data.length - 1; i++) {
            int jMin = i;

            for (int j = i + 1; j < data.length; j++) {
                if (comp.compareTo(data[j], (data[jMin])) < 0) {
                    jMin = j;
                }
            }

            if (jMin != i) {
                Object temp = data[i];
                data[i] = data[jMin];
                data[jMin] = temp;
            }
        }

        return data;
    }
}
