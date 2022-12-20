package pl.put.poznan.sorting.logic;

/**
 * Merge sort implementation.
 *
 */
public class MergeSort implements SortStrategy
{
    private Comparator comp;
    private int directionSwitch = 1;

    /**
     * Merges two subarrays of data[]
     * The method uses comparator class to compare objects.
     *
     * @param   data    data to sort (as an object)
     * @param   l       int, left end of a first subarray
     * @param   m       int, right end of a first subarray
     * @param   r       int, right end of a second subarray
     */
    void merge(Object[] data, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        Object[] L = new Object[n1];
        Object[] R = new Object[n2];

        for (int i = 0; i < n1; ++i)
            System.arraycopy(data, l + i, L, i, 1);
        for (int j = 0; j < n2; ++j)
            System.arraycopy(data, m + 1 + j, R, j, 1);


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (directionSwitch*comp.compareTo(L[i],R[j]) <= 0) {
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
     * Sorts data using MergeSort method.
     * Recursion function to sort all the subarrays.
     *
     * @param   data    data to sort (as an object)
     * @param   l       int, left end of a subarray
     * @param   r       int, right end of a subarray
     * @param   limit   int, number of iterations to run
     */
    void mergeSorting(Object[] data, int l, int r, int limit) {
        if (l < r && limit>0) {
            int m = l + (r - l) / 2;

            mergeSorting(data, l, m, limit-1);
            mergeSorting(data, m + 1, r, limit-1);

            merge(data, l, m, r);
        }
    }

    /**
     * Returns data sorted using MergeSort method.
     * The method uses Comparator class to compare objects
     * and overrides sort method from SortStrategy.
     *
     * @param   data        data to be sorted
     * @param   sortKey     sorting key used by Comparator to compare LinkedTreeMap objects
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
     * @return              array of data sorted with MergeSort algorithm.
     */
    @Override
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        comp = new Comparator(sortKey);
        directionSwitch = reverse ? -1 : 1;
        int temp;
        if (iterations <= 0) {
            temp = Integer.MAX_VALUE;
        }
        else {
            temp = iterations;
        }

        mergeSorting(data, 0, data.length-1, temp);

        return data;
    }

    /**
     * Get name of the sorting method.
     *
     * @return      name of the sorting algorithm.
     */
    @Override
    public String getName() {
        return "MergeSort";
    }
}
