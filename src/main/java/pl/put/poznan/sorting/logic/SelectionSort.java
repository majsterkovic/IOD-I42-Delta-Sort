package pl.put.poznan.sorting.logic;

/**
 * Selection sort implementation.
 */

public class SelectionSort implements SortStrategy {
    /**
     * Returns data sorted usunig slection sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data      data to sort (as an object)
     * @param   sortKey   string sorting key used by comparator
     * @return            data after selection sort sorting
     */
    @Override

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;
        boolean breakSort = (iterations > 0);

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

            if (breakSort && ++actualIteration >= iterations) {
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
