package pl.put.poznan.sorting.logic;

public class SortContext {

    private final SortStrategy strategy;

    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public Object[] sort(Object[] data, String sortKey) {
        return strategy.sort(data, sortKey);
    }

}
