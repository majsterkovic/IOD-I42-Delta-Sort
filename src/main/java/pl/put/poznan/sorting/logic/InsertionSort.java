package pl.put.poznan.sorting.logic;

public class InsertionSort implements SortStrategy {

    @Override
    public Object[] sort(Object[] data) {
        PrimitiveComparator comp = new PrimitiveComparator();
        int n = data.length;
        for (int i = 1; i < n; i++) {
            Object key = data[i];
            int j = i - 1;
            while (j >= 0 && comp.compareTo(data[j], key) > 0) {
                data[j+1] = data[j];
                j = j -1;
            }
            data[j+1] = key;
        }
        return data;
    }
}