package pl.put.poznan.sorting.logic;

public class MergeSort implements SortStrategy
{

    void merge(Object[] data, int l, int m, int r, Comparator comp) {

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


    void mergeSorting(Object[] data, int l, int r, Comparator comp) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSorting(data, l, m, comp);
            mergeSorting(data, m + 1, r, comp);

            merge(data, l, m, r, comp);
        }
    }

    //TODO: iterations counter and according break in the algorithm
    //TODO: implement
    @Override
    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        Comparator comp = new Comparator(sortKey);
        mergeSorting(data, 0, data.length-1, comp);

        return data;
    }

    @Override
    public String getName() {
        return "MergeSort";
    }
}