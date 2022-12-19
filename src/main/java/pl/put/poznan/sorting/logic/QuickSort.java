package pl.put.poznan.sorting.logic;

public class QuickSort implements SortStrategy
{


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


    void quickSorting(Object[] data, int low, int high, Comparator comp)
    {
        if (low < high)
        {

            int pi = partition(data, low, high, comp);

            quickSorting(data, low, pi-1, comp);
            quickSorting(data, pi+1, high, comp);
        }
    }

    //TODO: iterations counter and according break in the algorithm
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
