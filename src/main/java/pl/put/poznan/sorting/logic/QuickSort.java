package pl.put.poznan.sorting.logic;
/**
 * Quick sort implementation.
 *
 */

public class QuickSort implements SortStrategy
{

    /**
     * Returns index of a pivot element.
     * Takes last element and uses it as a pivot -
     * places it in the right place in the array and places
     * all smaller elements before it and all the bigger elements
     * after it.
     * The method usues comparator class to compare objects with one another.
     *
     * @param   data    data to sort (as an object)
     * @param   low     starting index
     * @param   high    ending index
     * @return          index of a pivot element
     */
    int partition(Object[] data, int low, int high, Comparator comp)
    {
        Object pivot = data[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            if (comp.compareTo(data[j], pivot) <= 0)
            {
                i++;

                Object temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        Object temp = data[i+1];
        data[i+1] = data[high];
        data[high] = temp;

        return i+1;
    }

    /**
     * Sorts data using quick sort method.
     * Use recursion to sort data by dividing it acording to pivot.
     *
     * @param   data      data to sort (as an object)
     * @param   low     starting index
     * @param   high    ending index
     */
    void quickSorting(Object[] data, int low, int high, Comparator comp)
    {
        if (low < high)
        {

            int pi = partition(data, low, high, comp);

            quickSorting(data, low, pi-1, comp);
            quickSorting(data, pi+1, high, comp);
        }
    }

    /**
     * Returns data sorted usunig quick sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data      data to sort (as an object)
     * @param   sortKey   string sorting key used by comparator
     * @return            data after quick sort sorting
     */
    @Override
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        Comparator comp = new Comparator(sortKey);
        int temp = data.length;
        quickSorting(data, 0, temp, comp);

        return data;
    }

    @Override
    public String getName() {
        return "QuickSort";
    }
}
