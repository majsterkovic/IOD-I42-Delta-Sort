package pl.put.poznan.sorting.logic;

/**
 * Bubble sort implementation.
 */

public class BubbleSort implements SortStrategy {

     /**
     * Returns data sorted usunig bubble sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data      data to sort (as an object)
     * @param   sortKey   string sorting key used by comparator
     * @return            data after bubble sort sorting
     */
    @Override
    public Object[] sort(Object[] data, String sortKey) {

        Comparator comp = new Comparator(sortKey);


        Object temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < (data.length - i); j++) {
                if (comp.compareTo(data[j - 1], (data[j])) > 0) {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }

        return data;
    }
}
