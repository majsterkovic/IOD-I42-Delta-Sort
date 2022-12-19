package pl.put.poznan.sorting.logic;

/**
 * Selection sort implementation.
 */

public class SelectionSort implements SortStrategy {

    @Override

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;

        for (int i = 0; i < data.length - 1; i++) {
            int jMin = i;

            for (int j = i + 1; j < data.length; j++) {
                if (directionSwitch * comp.compareTo(data[j], (data[jMin])) < 0) {
                    jMin = j;
                }
            }

            if (jMin != i) {
                Object temp = data[i];
                data[i] = data[jMin];
                data[jMin] = temp;
            }

            actualIteration++;
            if (actualIteration >= iterations) {
                break;
            }
        }

        return data;
    }

    @Override
    public String getName() {
        return "SelectionSort";
    }
}
