package pl.put.poznan.sorting.logic;
/**
 * Sorting wrapper implementation.
 *
 */
public class SortingWrapper {

    /**
     * Method to asaign adequate class according to chosen sort algorithm.
     * Creates new Class object (of chosen sorting algorithm.
     *
     * @param   type    type: String
     * @return          null
     */
    public SortStrategy getSorter(String type) {

        if (type.equals("bubble")) return new BubbleSort();
        if (type.equals("heap")) return new HeapSort();
        if (type.equals("insertion")) return new InsertionSort();
        if (type.equals("selection")) return new SelectionSort();
        if (type.equals("merge")) return new MergeSort();
        if (type.equals("quick")) return new QuickSort();

        return null;
    }
}
