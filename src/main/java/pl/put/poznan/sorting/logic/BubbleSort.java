package pl.put.poznan.sorting.logic;


/**
 * Bubble sort implementation.
 */

public class BubbleSort implements SortStrategy {

    @Override

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        boolean breakSort = (iterations > 0);
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;


        Object temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < (data.length - i); j++) {

                if (directionSwitch * comp.compareTo(data[j - 1], (data[j])) > 0)
                {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }

            if (breakSort && ++actualIteration >= iterations) {
                break;
            }
        }

        return data;
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }
}
