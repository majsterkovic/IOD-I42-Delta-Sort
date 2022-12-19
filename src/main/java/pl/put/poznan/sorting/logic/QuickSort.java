package pl.put.poznan.sorting.logic;

public class QuickSort implements SortStrategy {

    private Comparator comp;

    int partition(Object[] data, int low, int high) {
        Object pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (comp.compareTo(data[j], pivot) <= 0) {
                i++;

                Object temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        Object temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1;
    }


    void quickSorting(Object[] data, int low, int high) {
        if (low < high) {

            int pi = partition(data, low, high);

            quickSorting(data, low, pi - 1);
            quickSorting(data, pi + 1, high);
        }
    }

    @Override
    public Object[] sort(Object[] data, String sortKey) {
        comp = new Comparator(sortKey);
        int temp = data.length;
        quickSorting(data, 0, temp - 1);

        return data;
    }
}
