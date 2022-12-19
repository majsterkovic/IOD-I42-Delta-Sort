package pl.put.poznan.sorting.logic;

/**
 * Merge sort implementation.
 *
 */

public class MergeSort implements SortStrategy
{
    private Comparator comp;

    /**
     * Merges two subarrays of data[]
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data    data to sort (as an object)
     * @param   l       int, left end of a firts subarray
     * @param   m       int, right end of a fisrt subarray
     * @param   r       int, right end of a second subarray
     */
    void merge(Object[] data, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        Object[] L = new Object[n1];
        Object[] R = new Object[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = data[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = data[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (comp.compareTo(L[i],R[j]) <= 0) {
                data[k] = L[i];
                i++;
            } else {
                data[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Sorts data usunig merge sort method.
     * Recursion function to sort all the subarrays.
     *
     * @param   data    data to sort (as an object)
     * @param   l       int, left end of a subarray
     * @param   r       int, right end of a subarray
     */    
    void mergeSorting(Object[] data, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSorting(data, l, m);
            mergeSorting(data, m + 1, r);

            merge(data, l, m, r);
        }
    }
    
    /**
     * Returns data sorted usunig merge sort method.
     * The method usues comparator class to compare objects with one another
     * and overrides main sort method from SortStrategy.
     *
     * @param   data      data to sort (as an object)
     * @param   sortKey   string sorting key used by comparator
     * @return            data after merge sort sorting
     */
    @Override
    public Object[] sort(Object[] data, String sortKey) {
        comp = new Comparator(sortKey);
        mergeSorting(data, 0, data.length-1);

        return data;
    }

}
