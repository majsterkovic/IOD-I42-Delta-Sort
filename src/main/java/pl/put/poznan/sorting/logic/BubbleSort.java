package pl.put.poznan.sorting.logic;

/**
 * Bubble sort implementation.
 */

public class BubbleSort implements SortStrategy {

    @Override
    public int[] sort(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < (data.length - i); j++) {
                if (data[j - 1] > data[j]) {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }

    @Override
    public String[] sort(String[] data) {
        String temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < (data.length - i); j++) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }
}
