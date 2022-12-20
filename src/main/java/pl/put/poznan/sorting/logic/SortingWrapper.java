package pl.put.poznan.sorting.logic;
/**
 * Sorting wrapper implementation.
 *
 */
public class SortingWrapper {

    /**
     * Method to assign adequate class according to chosen sort algorithm.
     * Creates new Class object (of chosen sorting algorithm).
     *
     * @param   type    type: String
     * @return          new sort Object from chosen class or null if the selected type doesn't match any implemented sort method
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
