package pl.put.poznan.sorting.logic;

/**
 * Selection sort implementation.
 */

public class SelectionSort implements SortStrategy {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int jMin = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[jMin]) {
                    jMin = j;
                }
            }

            if (jMin != i) {
                int temp = data[i];
                data[i] = data[jMin];
                data[jMin] = temp;
            }
        }

        return data;
    }

    @Override
    public String[] sort(String[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int jMin = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[jMin]) < 0) {
                    jMin = j;
                }
            }

            if (jMin != i) {
                String temp = data[i];
                data[i] = data[jMin];
                data[jMin] = temp;
            }
        }

        return data;
    }
}
