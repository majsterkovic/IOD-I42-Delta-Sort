package pl.put.poznan.sorting.logic;

public class SortContext {

    private SortStrategy strategy;

    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public Object[] sort(Object[] data) {
        return strategy.sort(data);
    }

}
