package pl.put.poznan.sorting.logic;

public class MergeSort implements SortStrategy {
    private Comparator comp;

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
            if (comp.compareTo(L[i], R[j]) <= 0) {
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


    void mergeSorting(Object[] data, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSorting(data, l, m);
            mergeSorting(data, m + 1, r);

            merge(data, l, m, r);
        }
    }

    @Override
    public Object[] sort(Object[] data, String sortKey) {
        comp = new Comparator(sortKey);
        mergeSorting(data, 0, data.length - 1);

        return data;
    }

}