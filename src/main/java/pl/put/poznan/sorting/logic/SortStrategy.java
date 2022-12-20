package pl.put.poznan.sorting.logic;

/**
 * Sorting strategy implementation.
 */
public interface SortStrategy {
    /**
     * Sorting method strategy.
     * Method to define strategy for all sorting classes
     *
     * @param   input       type: Object[]
     * @param   key         type: String
     * @param   iterations  type: int
     * @param   reverse     type: boolean
     */
    Object[] sort(Object[] input, String key, int iterations, boolean reverse);

    /**
     * Getting name of the sort method.
     *
     * @return      name
     */
    String getName();

}