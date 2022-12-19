package pl.put.poznan.sorting.logic;

public class InsertionSort implements SortStrategy {

    @Override

    public Object[] sort(Object[] data, String sortKey, int iterations, boolean reverse) {
        int actualIteration = 0;
        Comparator comp = new Comparator(sortKey);
        int directionSwitch = reverse ? -1 : 1;

        int n = data.length;
        for (int i = 1; i < n; i++) {
            Object key = data[i];
            int j = i - 1;
            while (j >= 0 && directionSwitch * comp.compareTo(data[j], key) > 0) {
                data[j+1] = data[j];
                j = j -1;
            }
            data[j+1] = key;

            actualIteration++;
            if (actualIteration >= iterations) {
                break;
            }
        }
        return data;
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }
}